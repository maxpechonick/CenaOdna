import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import 'rxjs/add/operator/map';

const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class CategoryService {
  constructor(private http: Http) {}

  getAll() {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    let headers = new Headers();
    if (currentUser && currentUser.token) {
      headers.append('X-Authorization',`Bearer ${currentUser.token}`);
    }
    headers.append('Content-Type', 'application/json');
    return this.http.get(`${webServiceEndpoint}/category`, {headers}).map((response: Response) => response.json());
  }
}
