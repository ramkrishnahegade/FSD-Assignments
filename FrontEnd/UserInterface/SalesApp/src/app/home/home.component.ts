import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AuthenticationServiceService } from '../login/authentication-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser: User;


  constructor(private userService:AuthenticationServiceService) {
      this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
      console.log(this.currentUser.firstName)
  }

  ngOnInit() {
  }

  logout(){
    console.log("logout");
    this.userService.logout();
  }
}
