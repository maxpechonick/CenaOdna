import {Component} from "@angular/core";
import {User} from "../../entites/user";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent {
  user: User = new User();

  //todo password change

  constructor(private userService: UserService,
              private router: Router) {
    this.user = userService.getAuthUser();
    userService.authData.subscribe(
      data => {
        this.user = data;
      }
    );
  }

  update() {
    this.userService.update(this.user).subscribe(
      data => {
        this.router.navigate(['/profile'])
      },
      error => {
        alert('error');
      }
    )
  }

  updatePassword() {

  }
}
