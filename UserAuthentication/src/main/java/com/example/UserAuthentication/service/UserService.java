package com.example.UserAuthentication.service;

import com.example.UserAuthentication.exception.InvalidCredentialsException;
import com.example.UserAuthentication.exception.InvalidEmail;
import com.example.UserAuthentication.exception.UserAlreadyExistsException;
import com.example.UserAuthentication.exception.UserNotFoundException;
import com.example.UserAuthentication.model.User;

public interface UserService {

    User saveUser(User user) throws UserAlreadyExistsException;

    User findByUserIdAndPassword(String userId, String password) throws InvalidCredentialsException;

    User forgotPassword(String emailId) throws InvalidEmail;

    User updatePassword(String emailId,String password) throws UserNotFoundException;


}
