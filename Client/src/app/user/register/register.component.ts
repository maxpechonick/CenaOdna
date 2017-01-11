import {Component} from "@angular/core";
import {User} from "../../entites/user";
import {Router} from "@angular/router";
import {AlertService} from "../../services/alert.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: [ './register.component.css' ]
})
export class RegisterComponent {
  user: User;
  loading = false;
  constructor(
    private userService: UserService,
    private router: Router,
    private alertService: AlertService
  ) {}

  register(): void {
    this.loading = true;
    this.userService.create(this.user)
      .subscribe(
        data => {
          this.alertService.success('Registration successful', true);
          this.router.navigate(['/login']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }
}
