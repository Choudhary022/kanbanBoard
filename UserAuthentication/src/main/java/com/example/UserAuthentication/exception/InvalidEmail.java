package com.example.UserAuthentication.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT,reason="Email not Exists")
public class InvalidEmail extends Exception {


}
