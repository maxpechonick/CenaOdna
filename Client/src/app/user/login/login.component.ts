import {Component} from "@angular/core";
import {User} from "../../entites/user";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: [ './login.component.css' ]
})
export class LoginComponent {
  user: User = new User;
  token: string;
  refreshToken: string;

  constructor (
    private authService: AuthService,
    private router: Router
  ) {}

  login() {
    this.authService.login(this.user.username, this.user.password)
      .subscribe(
        data => {
          alert('success!');
          this.router.navigate([('/home')])
        },
        error => {
          alert("error, while login");
        }
      )
  }
}
