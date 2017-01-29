import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule} from "@angular/forms";
import {UserService} from "./services/user.service";
import {RegisterComponent} from "./user/register/register.component";
import {HttpModule, RequestOptions, Http} from "@angular/http";
import {LoginComponent} from "./user/login/login.component";
import {HomeComponent} from "./home/home.component";
import {CategoryComponent} from "./category/category.component";
import {MaterializeModule} from "angular2-materialize";
import {NgSpinningPreloader} from "ng2-spinning-preloader";
import {AuthService} from "./services/auth.service";
import {CategoryService} from "./services/category.service";
import {ProductService} from "./services/product.service";
import {authHttpServiceFactory} from "./factories/auth.factory";
import {AuthHttp, JwtHelper} from "angular2-jwt";
import {LoginGuard} from "./guards/login.guard";
import {ProfileComponent} from "./user/profile/profile.component";
import {AuthGuard} from "./guards/auth.guard";
import {MaterialModule} from "@angular/material";
import {SettingsComponent} from "./user/settings/settings.component";
import {ImageUploadComponent} from "./common/upload/upload.component";
import {FileUploadModule} from "ng2-file-upload";
import {Ng2CloudinaryModule} from "ng2-cloudinary";
import {NavigationComponent} from "./common/navigation/navigation.component";
import {FlexLayoutModule} from "@angular/flex-layout";
import {ProductComponent} from "./product/product.component";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    MaterializeModule,
    [MaterialModule.forRoot()],
    FileUploadModule,
    Ng2CloudinaryModule,
    [FlexLayoutModule.forRoot()]
  ],
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    ProfileComponent,
    SettingsComponent,
    ImageUploadComponent,
    NavigationComponent,
    CategoryComponent,
    ProductComponent
  ],
  providers: [
    UserService,
    NgSpinningPreloader,
    AuthService,
    CategoryService,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions]
    },
    JwtHelper,
    LoginGuard,
    AuthGuard,
    ProductService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {
}
