package com.example.UserAuthentication.service;

import com.example.UserAuthentication.exception.InvalidCredentialsException;
import com.example.UserAuthentication.exception.InvalidEmail;
import com.example.UserAuthentication.exception.UserAlreadyExistsException;
import com.example.UserAuthentication.exception.UserNotFoundException;
import com.example.UserAuthentication.model.User;
import com.example.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    private  UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {

   if(userRepository.findById(user.getEmailId()).isPresent())
   {
       throw new UserAlreadyExistsException();
   }
   return userRepository.save(user);

    }

    @Override
    public User findByUserIdAndPassword(String userId, String password) throws InvalidCredentialsException {
            User existingUser=userRepository.findUserByEmailIdAndPassword(userId,password);
            if(existingUser==null)
            {
                throw new InvalidCredentialsException();
            }

        return existingUser;
    }

    @Override
    public User forgotPassword(String emailId) throws InvalidEmail {

        if(userRepository.findById(emailId).isEmpty())
        {
              throw new InvalidEmail();
        }

        return userRepository.findById(emailId).get();
    }

    @Override
    public User updatePassword(String emailId, String password) throws UserNotFoundException {

        if(userRepository.findById(emailId).isPresent())
        {
            return userRepository.findById(emailId).get();
        }
        throw  new UserNotFoundException();
    }
}
