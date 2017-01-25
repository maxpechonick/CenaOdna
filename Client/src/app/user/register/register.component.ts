import {Component} from "@angular/core";
import {User} from "../../entites/user";
import {UserService} from "../../services/user.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: User = new User;
  loading = false;

  constructor(private userService: UserService,
              private authService: AuthService) {
  }

  register(): void {
    this.loading = true;
    this.userService.create(this.user)
      .subscribe(
        data => {
          this.authService.login(data.username, data.password);
        },
        error => {
          this.loading = false;
          alert(error._body);
        });
  }
}
