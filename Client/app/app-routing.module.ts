import {Routes, RouterModule} from "@angular/router";
import {NgModule} from "@angular/core";
import {RegisterComponent} from "./user/register/register.component";
import {APP_BASE_HREF} from "@angular/common";
const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  providers: [{provide: APP_BASE_HREF, useValue : '/' }]
})
export class AppRoutingModule {}
