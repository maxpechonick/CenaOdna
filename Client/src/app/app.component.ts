import { Component, OnInit } from '@angular/core';
import {NgSpinningPreloader} from "ng2-spinning-preloader";

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  constructor(private ngSpinningPreloader: NgSpinningPreloader) {}

  ngOnInit() {
    this.ngSpinningPreloader.stop();
  }
}
