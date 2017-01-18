import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {AuthHttp} from "angular2-jwt";
import "rxjs/add/operator/map";

const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class CategoryService {
  constructor(private http: AuthHttp) {
  }

  getAll() {
    return this.http.get(`${webServiceEndpoint}/category`).map((response: Response) => response.json());
  }
}
