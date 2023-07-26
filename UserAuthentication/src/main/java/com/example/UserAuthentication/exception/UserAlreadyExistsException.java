package com.example.UserAuthentication.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "User already exits")
public class UserAlreadyExistsException extends Exception {
}
