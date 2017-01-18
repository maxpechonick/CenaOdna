import {Injectable, Output, EventEmitter} from "@angular/core";
import {Response, Http, Headers} from "@angular/http";
import {AuthHttp, JwtHelper} from "angular2-jwt";


const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class AuthService {
  public token: string;

  @Output() isLoggedIn: EventEmitter<boolean> = new EventEmitter();

  constructor(private http: Http,
              private authHttp: AuthHttp) {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
  }

  login(username: string, password: string) {
    return this.http.post(`${webServiceEndpoint}/auth/login`,
      JSON.stringify({username: username, password: password}))
      .map((response: Response) => {
        let token = response.json() && response.json().token;
        let refresh = response.json() && response.json().refreshToken;
        if (token) {
          this.token = token;
          localStorage.setItem('token', token);
          this.isLoggedIn.emit(true);
        }
        if (refresh) {
          localStorage.setItem('refresh', refresh);
        }
      });
  }

  logout() {
    this.token = null;
    this.refreshToken = null;
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
          this.token = token;
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
}
