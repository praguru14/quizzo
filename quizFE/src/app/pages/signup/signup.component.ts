import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService,private _snack:MatSnackBar) { }

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
   // alert("Kindly enter Username");
   this._snack.open("Kindly enter Username", "ok", {
     duration: 3000,
    //  verticalPosition:'top',
    //  horizontalPosition:'right'
   } );
    return;
  }
  this.userService.addUser(this.user).subscribe(
    (response:any)=>{
      console.log(response);
      //alert("User added successfully");
      Swal.fire({
        position: 'center',
        text: 'User '+this.user.username+' added successfully',
        icon: 'success',
        title: 'Added',
        showConfirmButton: true,
        timer: 2000
      })
    },
    (error)=>{
      console.log(error);
      alert("Error while adding user");
    }

  );

}
}
