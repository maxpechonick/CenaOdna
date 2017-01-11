import {AbstractEntity} from "./abstractentity";
import {Product} from "./product";
export class Basket extends AbstractEntity{
  quantity: number;
  product: Product;
}
