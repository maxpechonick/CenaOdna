import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import {AuthService} from "../services/auth.service";

@Injectable()
export class LoginGuard implements CanActivate {
	constructor(private router: Router
		) {}

	canActivate() {
		if (!AuthService.loggedIn()) {
			return true;
		}

		this.router.navigate(['/home']);
		return false;
	}
}
