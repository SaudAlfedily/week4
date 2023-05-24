package com.example.blog.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {

//    private final String health="health";
//    private final String education="education";
//    private final String programming="programming";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String title;

//    @Pattern(regexp = "^(" + health + "|" + education +"|" + programming + ")",message = "not valid category have to be  ( health,education,programming) ).") //health or education or programming
    @NotEmpty(message = "category should not be empty")
    @Column(columnDefinition = "varchar(20) not null  check (category='health' or category='education' or category='programming')")
    private String category;

    @Size(max = 300)
    @NotEmpty(message = "body should not be empty")
    @Column(columnDefinition = "varchar(300) not null")
    private String body;

    @AssertFalse(message = "published should be false")
    @Column(columnDefinition = "boolean default false")
    private boolean isPublished;

}
