import {Routes, RouterModule} from "@angular/router";
import {NgModule} from "@angular/core";
import {RegisterComponent} from "./user/register/register.component";
import {APP_BASE_HREF} from "@angular/common";
import {LoginComponent} from "./user/login/login.component";
import {HomeComponent} from "./home/home.component";
import {LoginGuard} from "./guards/login.guard";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'register', component: RegisterComponent, canActivate: [LoginGuard]},
  {path: 'login', component: LoginComponent, canActivate: [LoginGuard]},
  {path: 'home', redirectTo: ''},

  {path: '**', redirectTo: ''}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [{provide: APP_BASE_HREF, useValue: '/'}]
})
export class AppRoutingModule {
}
