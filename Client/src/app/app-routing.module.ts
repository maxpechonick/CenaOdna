import {Routes, RouterModule} from "@angular/router";
import {NgModule} from "@angular/core";
import {RegisterComponent} from "./user/register/register.component";
import {APP_BASE_HREF} from "@angular/common";
import {LoginComponent} from "./user/login/login.component";
import {HomeComponent} from "./home/home.component";
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  providers: [{provide: APP_BASE_HREF, useValue : '/'}]
})
export class AppRoutingModule {}
