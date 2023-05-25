package com.example.exerciswek4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotEmpty(message = "username should not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;

    @NotEmpty(message = "passworf should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:")
    private String password;

    @Email(message = "email should be valid ")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;  //(valid email) (check unique)
}
