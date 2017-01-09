import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule} from "@angular/forms";
import {AlertService} from "./services/alert.service";
import {UserService} from "./services/user.service";
import {RegisterComponent} from "./user/register/register.component";
import {HttpModule} from "@angular/http";

@NgModule({
  imports:      [
    BrowserModule ,
    AppRoutingModule,
    FormsModule,
    HttpModule
  ],
  declarations: [
    AppComponent,
    RegisterComponent
  ],
  bootstrap:    [
    AppComponent
  ],
  providers: [
    UserService,
    AlertService
  ]
})
export class AppModule { }
