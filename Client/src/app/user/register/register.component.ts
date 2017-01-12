import {Component} from "@angular/core";
import {User} from "../../entites/user";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: [ './register.component.css' ]
})
export class RegisterComponent {
  user: User = new User;
  loading = false;
  constructor(
    private userService: UserService,
    private router: Router
  ) {}

  register(): void {
    this.loading = true;
    this.userService.create(this.user)
      .subscribe(
        data => {
          this.router.navigate(['/login']);
        },
        error => {
          this.loading = false;
          alert(error._body);
        });
  }
}
