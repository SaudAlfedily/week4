package com.example.project4.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Cannot be null

    @NotEmpty(message = "name can not be null")
    @Size(min = 3, message = "name Length more than 2")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String name;  // Cannot be null  Length more than 2

    @NotEmpty(message = "genre can not be null")
    @Pattern(regexp = "^(" + "Drama" + "|" + "Action" + "|" + "Comedy" + ")", message = "genre should be Drama or Action or Comedy ")
    @Column(columnDefinition = "varchar(20) not null check (genre='Drama' or genre='Action' or genre='Comedy')")
    private String genre; //Cannot be null  Validation //(Drama|Action|Comedy)

    @NotNull(message = "Rating  can not be null")
    @Min(value = 1, message = "Rating must be between 1 - 5")
    @Max(value = 5, message = "Rating must be between 1 - 5")
    @Column(columnDefinition = "int not null")
    private int rating;// Cannot be null  I must be between 1 - 5

    @NotNull(message = "duration can not be null")
    @Min(value = 61, message = "duration more than 60")
    @Column(columnDefinition = "int not null")
    private Integer duration;//in minutes  //: Cannot be null   It must be more than 60

    @NotNull(message = "director Id must not be null")
    private Integer directorid;

}
