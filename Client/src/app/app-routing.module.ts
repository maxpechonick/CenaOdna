import {Routes, RouterModule} from "@angular/router";
import {NgModule} from "@angular/core";
import {RegisterComponent} from "./user/register/register.component";
import {APP_BASE_HREF} from "@angular/common";
import {LoginComponent} from "./user/login/login.component";
import {HomeComponent} from "./home/home.component";
import {LoginGuard} from "./guards/login.guard";
import {ProfileComponent} from "./user/profile/profile.component";
import {AuthGuard} from "./guards/auth.guard";
import {SettingsComponent} from "./user/settings/settings.component";
import {CategoryComponent} from "./category/category.component";
import {ProductComponent} from "./product/product.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'register', component: RegisterComponent, canActivate: [LoginGuard]},
  {path: 'login', component: LoginComponent, canActivate: [LoginGuard]},
  {path: 'home', redirectTo: ''},
  {path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]},
  {path: 'settings', component: SettingsComponent, canActivate: [AuthGuard]},
  {path: 'category/:id', component: CategoryComponent},
  {path: 'product/:id', component: ProductComponent},

  {path: '**', redirectTo: ''}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [{provide: APP_BASE_HREF, useValue: '/'}]
})
export class AppRoutingModule {
}
