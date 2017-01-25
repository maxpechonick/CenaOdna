import {Injectable, EventEmitter, Output} from "@angular/core";
import {Response} from "@angular/http";
import {User} from "../entites/user";
import {AuthHttp} from "angular2-jwt";
import "rxjs/add/operator/map";
import {AuthService} from "./auth.service";


const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class UserService {

  private user: User = new User();
  @Output() authData: EventEmitter<User> = new EventEmitter();

  constructor(private http: AuthHttp) {
    if (AuthService.loggedIn()) {
      this.getCurrentUser().subscribe(
        data => {
          this.user = data;
          this.authData.emit(this.user);
        }
      );
    }
  }

  getAuthUser(): User {
    return this.user;
  }

  updateAuthUser(user: User) {
    this.user = user;
    this.authData.emit(user);
  }

  getAll() {
    return this.http.get(`${webServiceEndpoint}/user`).map((response: Response) => response.json());
  }

  getById(id: number) {
    return this.http.get(`${webServiceEndpoint}/user/` + id).map((response: Response) => response.json());
  }

  create(user: User) {
    return this.http.post(`${webServiceEndpoint}/user`, user).map((response: Response) => response.json());
  }

  update(user: User) {
    return this.http.put(`${webServiceEndpoint}/protected/user`, user).map((response: Response) => {
      if (response.json()) {
        this.updateAuthUser(response.json());
      }
      response.json();
    });
  }

  delete(id: number) {
    return this.http.delete(`${webServiceEndpoint}/protected/user/` + id).map((response: Response) => response.json());
  }

  getCurrentUser() {
    return this.http.get(`${webServiceEndpoint}/protected/user/me`).map((response: Response) => response.json());
  }
}
