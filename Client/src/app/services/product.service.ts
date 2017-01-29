import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";

const webServiceEndpoint: string = 'http://localhost:8080/api';

@Injectable()
export class ProductService {

  constructor(private http: Http) {
  }

  public getAllForCategory(categoryId: number) {
    return this.http.get(`${webServiceEndpoint}/product/category/${categoryId}`).map((response: Response) => response.json());
  }
}
