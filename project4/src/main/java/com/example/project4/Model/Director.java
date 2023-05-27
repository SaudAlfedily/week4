package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Cannot be null


    @NotEmpty(message = "director name can not be empty")
    @Size(min = 3, message = "director name should be more than 2")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    // Cannot be null
    // Length more than 2



}
