import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService) { }

  public user={
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phoneNo:''
  }
  
  ngOnInit(): void {
    
  }
  formSubmit() {
    console.log(this.user);
    if(this.user.username==''||this.user.username==null){
    alert("Kindly enter Username");
    return;
  }
  this.userService.addUser(this.user).subscribe(
    (response)=>{
      console.log(response);
      alert("User added successfully");
    },
    (error)=>{
      console.log(error);
      alert("Error while adding user");
    }

  );

}
}
