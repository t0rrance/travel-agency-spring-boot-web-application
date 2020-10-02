import { Component } from '@angular/core';
import {UserService} from "./service/user.service";
import {Router} from "@angular/router";
import {User} from "./auth/model/user";
import {Role} from "./auth/model/role";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Travel agency';
  currentUser: User;

  constructor(private userService: UserService, private router: Router){
    this.userService.currentUser.subscribe(data => {
      this.currentUser = data;
    })
  }

  logOut(){
    this.userService.logOut().subscribe(data => {
      this.router.navigate(['/login']);
    })
  }

  get isAdmin(){
    return this.currentUser && this.currentUser.role === Role.ADMIN;
  }

  get isLogged() {
    return this.currentUser;
  }

}
