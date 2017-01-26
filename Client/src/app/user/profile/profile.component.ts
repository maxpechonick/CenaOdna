import {Component, OnInit} from "@angular/core";
import {User} from "../../entites/user";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  user: User = new User;

  constructor(private userService: UserService,
              private router: Router) {
    this.user = userService.getAuthUser();
    userService.authData.subscribe(
      data => {
        this.user = data;
      }
    );
  }

  ngOnInit(): void {

  }
}
