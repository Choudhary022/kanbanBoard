package com.example.UserAuthentication.repository;

import com.example.UserAuthentication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User,String> {


   public User findUserByEmailIdAndPassword(String emailId, String password);

}
