import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';
import { User } from 'src/app/model/user.model';
import { Router } from '@angular/router';
import * as $ from 'jquery';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  messageOnCon: string;
  status: any;
  messageOnRegSuc: string;
  $:any;

  constructor(private loginService:LoginService, private router: Router) { }
  registrationForm = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    conpassword: new FormControl(''),
  });
  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });
  ngOnInit(): void {
    var $loginMsg = $('.loginMsg'),
    $login = $('.login'),
    $signupMsg = $('.signupMsg'),
    $signup = $('.signup'),
    $frontbox = $('.frontbox');
  
  $('#switch1').on('click', function() {
    $loginMsg.toggleClass("visibility");
    $frontbox.addClass("moving");
    $signupMsg.toggleClass("visibility");
  
    $signup.toggleClass('hide');
    $login.toggleClass('hide');
  })
  
  $('#switch2').on('click', function() {
    $loginMsg.toggleClass("visibility");
    $frontbox.removeClass("moving");
    $signupMsg.toggleClass("visibility");
  
    $signup.toggleClass('hide');
    $login.toggleClass('hide');
  })
  
  setTimeout(function(){
    $('#switch1').click()
  },1000)
  
  setTimeout(function(){
    $('#switch2').click()
  },3000)
  }
  onRegister(){
    this.user = new User();
    this.user.useremail=this.registrationForm.value.email;
    this.user.username= this.registrationForm.value.username;
    if(this.registrationForm.value.password==this.registrationForm.value.conpassword){
      this.user.userpass= this.registrationForm.value.password;
    }else{
      alert('Password and confirm password are not same!')
      this.messageOnCon = 'Password and confirm password are not same';
    }
    this.loginService.registerNewUser(this.user).subscribe(res=>{
      this.status = res;
      console.log(res)
      if(this.status){
        alert('Registration Success you can go to login!');
      }
    })
   }

  onLogin(){
    this.user = new User();
    this.user.username=this.loginForm.value.username;
    this.user.userpass=this.loginForm.value.password;
    this.loginService.loginUser(this.user).subscribe(res=>{
      console.log(res)
      this.status = res;
      if(this.status!='fail'){
        this.router.navigateByUrl('/home');
        alert('Welcome to my quiz '+ this.status);
       localStorage.setItem('uname',this.user.username );
      }else{
        alert('Bad credentials!')
      }
    })
  }
  // onLogin() {
  //   console.log('going home')
  //   this.router.navigateByUrl('/home');
  // }
}
