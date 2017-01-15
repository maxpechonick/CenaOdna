import { Component, OnInit } from '@angular/core';
import {NgSpinningPreloader} from "ng2-spinning-preloader";
import {AuthService} from "./services/auth.service";

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {

  private isLoggedIn: boolean;

  constructor(
    private ngSpinningPreloader: NgSpinningPreloader,
    private authService: AuthService
  ) {
    this.isLoggedIn = !!authService.token;
  }

  logout() {
    this.authService.logout();
  }

  ngOnInit() {
    this.ngSpinningPreloader.stop();
    this.authService.getState().subscribe(item => this.isLoggedIn = item);
  }
}
