import {Category} from "./category";
import {AbstractEntity} from "./abstractentity";
export class Product extends AbstractEntity{
  name: string;
  description: string;
  length: number;
  height: number;
  width: number;
  quantity: number;
  category: Category;
}
