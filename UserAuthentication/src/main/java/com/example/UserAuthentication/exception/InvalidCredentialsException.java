package com.example.UserAuthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT,reason="Invalid Credential")
public class InvalidCredentialsException extends Exception {
}
