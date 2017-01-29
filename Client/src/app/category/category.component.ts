import {Component} from "@angular/core";
import {Category} from "./../entites/category";
import {CategoryService} from "./../services/category.service";
import {ProductService} from "./../services/product.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Product} from "./../entites/product";

declare var $: any;

@Component({
  moduleId: module.id,
  selector: 'category-detail',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {

  private category: Category = new Category();
  private products: Product[] = [];

  constructor(private route: ActivatedRoute,
              private categoryService: CategoryService,
              private productService: ProductService) {
    route.params.switchMap((params: Params) => categoryService.getCategory(+params['id']))
      .subscribe(data => this.category = data);
    route.params.switchMap((params: Params) => productService.getAllForCategory(+params['id']))
      .subscribe(data => this.products = data.content);
  }

  private addToCart(product: Product) {

  }

  private markAsFavorite(product: Product) {

  }


}
