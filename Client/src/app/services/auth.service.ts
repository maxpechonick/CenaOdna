import {Injectable, Output, EventEmitter} from "@angular/core";
import {Response, Http} from "@angular/http";


const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class AuthService {
  public token: string;
  public refreshToken: string;

  @Output() isLoggedIn: EventEmitter<boolean> = new EventEmitter();

  constructor(private http: Http) {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
  }

  login(username: string, password: string) {
    return this.http.post(`${webServiceEndpoint}/auth/login`,
      JSON.stringify({username: username, password: password}))
      .map((response: Response) => {
        let token = response.json() && response.json().token;
        let refreshToken = response.json() && response.json().refreshToken;
        if(token) {
          this.token = token;
          localStorage.setItem('currentUser', JSON.stringify({username: username, token: token}));
          this.isLoggedIn.emit(true);
        }
        if (refreshToken) {
          this.refreshToken = refreshToken;
          localStorage.setItem('refreshToken', JSON.stringify(({refreshToken: refreshToken})));
        }
      });
  }

  logout() {
    this.token = null;
    this.refreshToken = null;
    localStorage.removeItem('currentUser');
    localStorage.removeItem('refreshToken');
    this.isLoggedIn.emit(false);
  }

  getState() {
    return this.isLoggedIn;
  }
}
