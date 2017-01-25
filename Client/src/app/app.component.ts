import {Component, OnInit} from "@angular/core";
import {NgSpinningPreloader} from "ng2-spinning-preloader";
import {AuthService} from "./services/auth.service";
import {User} from "./entites/user";
import {UserService} from "./services/user.service";

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private isLoggedIn: boolean;
  private user: User;

  constructor(private ngSpinningPreloader: NgSpinningPreloader,
              private authService: AuthService,
              private userServise: UserService) {
    this.user = new User();
    this.isLoggedIn = AuthService.canBeRefreshed();
    authService.isLoggedIn.subscribe(item => {
      this.isLoggedIn = item;
    });
    userServise.authData.subscribe(item => {
      this.user = item;
    });
  }

  logout() {
    this.authService.logout();
  }

  ngOnInit() {
    this.ngSpinningPreloader.stop();
    if (AuthService.canBeRefreshed()) {
      this.authService.startupTokenRefresh();
    }
  }
}
