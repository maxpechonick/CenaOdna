import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule} from "@angular/forms";
import {UserService} from "./services/user.service";
import {RegisterComponent} from "./user/register/register.component";
import {HttpModule} from "@angular/http";
import {LoginComponent} from "./user/login/login.component";
import {HomeComponent} from "./home/home.component";
import { MaterializeModule } from 'angular2-materialize';

@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    MaterializeModule
  ],
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent
  ],
  providers: [
    UserService
  ],
  bootstrap:    [
    AppComponent
  ]
})
export class AppModule { }
