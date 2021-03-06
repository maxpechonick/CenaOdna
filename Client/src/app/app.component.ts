import {Component, OnInit} from "@angular/core";
import {NgSpinningPreloader} from "ng2-spinning-preloader";
import {AuthService} from "./services/auth.service";

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private isLoggedIn: boolean;

  constructor(private ngSpinningPreloader: NgSpinningPreloader,
              private authService: AuthService) {}

  ngOnInit() {
    this.ngSpinningPreloader.stop();
    if (AuthService.canBeRefreshed()) {
      this.authService.startupTokenRefresh();
    }
  }
}
