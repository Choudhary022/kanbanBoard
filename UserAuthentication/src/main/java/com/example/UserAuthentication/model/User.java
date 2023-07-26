package com.example.UserAuthentication.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

     @Id
     private String emailId;

     private String password;


}
