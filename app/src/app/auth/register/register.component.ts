import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';
import {User} from "../model/user";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  errorMessage: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    if(this.userService.currentUserValue) {
      this.router.navigate(['/profile']);
      return;
    }
  }

  register() {
    this.userService.register(this.user).subscribe(data => {
      this.router.navigate(['/login']);
    }, err => {
      this.errorMessage = "Nazwa użytkownika już istnieje!";
    });
  }

}
