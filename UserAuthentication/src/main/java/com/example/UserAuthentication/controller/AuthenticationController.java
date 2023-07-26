package com.example.UserAuthentication.controller;

import com.example.UserAuthentication.exception.InvalidCredentialsException;
import com.example.UserAuthentication.exception.InvalidEmail;
import com.example.UserAuthentication.exception.UserAlreadyExistsException;
import com.example.UserAuthentication.exception.UserNotFoundException;
import com.example.UserAuthentication.model.User;
import com.example.UserAuthentication.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    private UserServiceImp  userServiceImp;

    @Autowired
    public AuthenticationController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping("/registerUser")
 public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException
 {
    return new ResponseEntity<>(userServiceImp.saveUser(user), HttpStatus.CREATED);

 }

 @GetMapping("/login")
 public ResponseEntity<?> login(@RequestBody User user ) throws InvalidCredentialsException
 {
     return new ResponseEntity<>(userServiceImp.findByUserIdAndPassword(user.getEmailId(),user.getPassword()),HttpStatus.OK);

 }


 @GetMapping("/forgotPassword")
public ResponseEntity<?> forgotPassword (@RequestBody String email ) throws InvalidEmail {
        return new ResponseEntity<>(userServiceImp.forgotPassword(email),HttpStatus.OK);
 }


@PostMapping("/updatePassword")
public ResponseEntity<?>  updatePassword (@RequestBody User user) throws UserNotFoundException{
        return new ResponseEntity<>(userServiceImp.updatePassword(user.getEmailId(),user.getPassword()),HttpStatus.OK);
}


}
