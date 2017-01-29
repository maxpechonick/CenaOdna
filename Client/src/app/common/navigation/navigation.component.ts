import {Component, OnInit} from "@angular/core";
import {User} from "./../../entites/user";
import {UserService} from "./../../services/user.service";
import {AuthService} from "./../../services/auth.service";
import {CategoryService} from "./../../services/category.service";
import {Category} from "./../../entites/category";

declare var $: any;

@Component({
  moduleId: module.id,
  selector: 'common-nav',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  private isLoggedIn: boolean;
  private user: User = new User();
  private categories: Category[] = [];

  constructor(private userServise: UserService,
              private authService: AuthService,
              private categoryService: CategoryService) {
    userServise.authData.subscribe(item => {
      this.user = item;
    });
    this.isLoggedIn = AuthService.canBeRefreshed();
    authService.isLoggedIn.subscribe(item => {
      this.isLoggedIn = item;
    });
    categoryService.getAll().subscribe(
      data => {
        this.categories = data;
      }
    )
  }

  ngOnInit(): void {
    $(".button-collapse").sideNav({
      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: true // Choose whether you can drag to open on touch screens
    });
  }

  logout() {
    this.authService.logout();
  }

}
