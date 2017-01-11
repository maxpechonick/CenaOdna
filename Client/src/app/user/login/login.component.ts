import {Component} from "@angular/core";
import {User} from "../../entites/user";
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: [ './login.component.css' ]
})
export class LoginComponent {
  user: User;
  login() {
    alert("login");
  }
}
