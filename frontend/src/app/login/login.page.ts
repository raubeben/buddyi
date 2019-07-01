import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from '../services/token.service';
import { UserAuthResponse } from '../model/userAuthResponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private router:Router, private tokenService:TokenService) { 

  }

  public currentAuthentification: UserAuthResponse = null;

  public userName:string = "";
  public password:string = "";

  ngOnInit() {
  }

  async login() {
    this.tokenService.login(this.userName,this.password).subscribe(data => {
      this.currentAuthentification = data;
      this.password = "";
      this.router.navigateByUrl('/tabs/todo');
    }, err => {
      console.log(err);
    });
  }
}
