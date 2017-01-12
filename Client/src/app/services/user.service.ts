import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {User} from "../entites/user";

import 'rxjs/add/operator/map';
const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class UserService {
  constructor(private http: Http) { }

  getAll() {
    return this.http.get(`${webServiceEndpoint}/user`, this.jwt()).map((response: Response) => response.json());
  }

  getById(id: number) {
    return this.http.get(`${webServiceEndpoint}/user/` + id, this.jwt()).map((response: Response) => response.json());
  }

  create(user: User) {
    return this.http.post(`${webServiceEndpoint}/user`, user).map((response: Response) => response.json());
  }

  update(user: User) {
    return this.http.put(`${webServiceEndpoint}/user/` + user.rid, user).map((response: Response) => response.json());
  }

  delete(id: number) {
    return this.http.delete(`${webServiceEndpoint}/user/` + id, this.jwt()).map((response: Response) => response.json());
  }

  // private helper methods

  private jwt() {
    // create authorization header with jwt token
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
      return new RequestOptions({ headers: headers });
    }
  }
}
