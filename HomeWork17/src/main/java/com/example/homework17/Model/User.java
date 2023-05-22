package com.example.homework17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ID;

    @NotEmpty(message = "name can not be empty")
    @Size(min = 5,message ="user name size need to be more than 4" )
    @Column(columnDefinition = "varchar(20) not null ")
  private String name;

    @NotEmpty(message = "user name can not be empty")
    @Size(min = 5,message = "user name size need to be more than 4")
    @Column(columnDefinition = "varchar(20) not null unique")
  private String username ;


    @NotEmpty(message = "can not be empty")

    @Column(columnDefinition = "varchar(20) not null ")
  private String password;

    @NotEmpty(message = "email can not be empty")
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
  private String email;

    @NotEmpty(message = "role can not be empty")
    @Column(columnDefinition = "varchar(20) not null check (role='user' or role='admin')")
  private  String role;

    @NotNull(message = "age can not be empty")
    @Column(columnDefinition = "int not null")
  private  Integer age;

}
