import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private http:HttpClient) {}

  userlogin:Boolean=false;
  agentlogin:Boolean=false;
  submitted:Boolean=false;

  username:any;
  password:any;
  userrole:any;

  loginForm=new FormGroup({
    username:new FormControl(),
    password:new FormControl()
  });

  onSubmit()
  {
      console.log(this.loginForm.value);
      this.username=this.loginForm.value.username;
      this.password=this.loginForm.value.password;
      let role=this.http.get(`http://localhost:8088/login/id/${this.username}/${this.password}/${"login"}`);
      role.subscribe((data)=>{
        this.userrole=data;
        console.log(this.userrole);})
      if(this.userrole===0)
      {
        this.submitted=true;
        this.userlogin=true;
      }
      else if(this.userrole===1)
      {
        this.submitted=true;
        this.agentlogin=true;
      }
  }
  logout()
  {
      let role=this.http.get(`http://localhost:8088/login/id/${this.username}/${this.password}/${"logout"}`);
      role.subscribe((data)=>{
        this.userrole=data;
        console.log(this.userrole);})
      if(this.userlogin==true)
      {
        this.submitted=false;
        this.userlogin=false;
      }
      else
      {
        this.submitted=false;
        this.agentlogin=false;
      }
      console.log("logged out");
  }
}
//  this.hist=true;
//     let role=this.http.get('http://localhost:8088/calci/history');
//     calc.subscribe((data)=>{
//       this.calcu=data;
//       console.log(this.calcu);
      
//       try {
//         this.result1 = eval(this.result);
//         const cal:Calci={equation:this.result,value:this.result1};
//         this.http.post('http://localhost:8088/calci/addcal',cal).subscribe(
//           savedData => console.log("Data added successfully", savedData),
//           error => console.log("Error", error)
//         );
//         this.result=this.result1;
//         this.result1='';