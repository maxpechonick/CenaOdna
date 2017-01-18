import {Injectable, Output, EventEmitter} from "@angular/core";
import {Response, Http, Headers} from "@angular/http";
import {AuthHttp, JwtHelper} from "angular2-jwt";
import {Observable} from "rxjs";


const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class AuthService {
  refreshSubscription: any;

  @Output() isLoggedIn: EventEmitter<boolean> = new EventEmitter();

  constructor(private http: Http,
              private authHttp: AuthHttp,
              private jwtHelper: JwtHelper
  ) {}

  login(username: string, password: string) {
    return this.http.post(`${webServiceEndpoint}/auth/login`,
      JSON.stringify({username: username, password: password}))
      .map((response: Response) => {
        let token = response.json() && response.json().token;
        let refresh = response.json() && response.json().refreshToken;
        if (token) {
          localStorage.setItem('token', token);
          this.isLoggedIn.emit(true);
        }
        if (refresh) {
          localStorage.setItem('refresh', refresh);
        }
        if (response.status == 200) {
          this.startupTokenRefresh();
        }
      });
  }

  logout() {
    this.unscheduleRefresh();
    localStorage.removeItem('token');
    localStorage.removeItem('refresh');
    this.isLoggedIn.emit(false);
  }

  refreshToken() {
    let headers: Headers = new Headers();
    headers.append('X-Authorization', 'Bearer ' + localStorage.getItem('refresh'));
    return this.http.get(`${webServiceEndpoint}/auth/token`, {headers})
      .map((response: Response) => {
        console.log(response);
        let token = response.json() && response.json().token;
        console.log('token: ', token);
        if (token) {
          localStorage.setItem('token', token);
        }
      })
  }

  getState() {
    return this.isLoggedIn;
  }

  public static loggedIn(): boolean {
    let jwt: JwtHelper = new JwtHelper();
    return localStorage.getItem('token') !== null && !jwt.isTokenExpired(localStorage.getItem('token'));
  }

  public scheduleRefresh() {
    // If the user is authenticated, use the token stream
    // provided by angular2-jwt and flatMap the token
    let source = this.authHttp.tokenStream.flatMap(
      token => {
        // The delay to generate in this case is the difference
        // between the expiry time and the issued at time
        let jwtIat = this.jwtHelper.decodeToken(token).iat;
        let jwtExp = this.jwtHelper.decodeToken(token).exp;
        let iat = new Date(0);
        let exp = new Date(0);

        let delay = (exp.setUTCSeconds(jwtExp) - iat.setUTCSeconds(jwtIat));

        return Observable.interval(delay);
      });

    this.refreshSubscription = source.subscribe(() => {
      this.refreshToken();
    });
  }

  public startupTokenRefresh() {
    // If the user is authenticated, use the token stream
    // provided by angular2-jwt and flatMap the token
    if (AuthService.loggedIn()) {
      let source = this.authHttp.tokenStream.flatMap(
        token => {
          // Get the expiry time to generate
          // a delay in milliseconds
          let now: number = new Date().valueOf();
          let jwtExp: number = this.jwtHelper.decodeToken(token).exp;
          let exp: Date = new Date(0);
          exp.setUTCSeconds(jwtExp);
          let delay: number = exp.valueOf() - now;

          // Use the delay in a timer to
          // run the refresh at the proper time
          return Observable.timer(delay);
        });

      // Once the delay time from above is
      // reached, get a new JWT and schedule
      // additional refreshes
      source.subscribe(() => {
        this.refreshToken();
        this.scheduleRefresh();
      });
    }
  }

  public unscheduleRefresh() {
    // Unsubscribe fromt the refresh
    if (this.refreshSubscription) {
      this.refreshSubscription.unsubscribe();
    }
  }
}
