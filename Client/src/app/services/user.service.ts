import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {User} from "../entites/user";
import {AuthHttp} from "angular2-jwt";
import "rxjs/add/operator/map";


const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class UserService {
  constructor(private http: AuthHttp) {
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
    return this.http.put(`${webServiceEndpoint}/protected/user`, user).map((response: Response) => response.json());
  }

  delete(id: number) {
    return this.http.delete(`${webServiceEndpoint}/protected/user/` + id).map((response: Response) => response.json());
  }

  getCurrentUser() {
    return this.http.get(`${webServiceEndpoint}/protected/user/me`).map((response: Response) => response.json());
  }
}
