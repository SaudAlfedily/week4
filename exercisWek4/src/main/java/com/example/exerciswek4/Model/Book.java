package com.example.exerciswek4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String title;

    @Column(columnDefinition = "varchar(30) not null")
    @NotEmpty(message = "Author should not be empty")
    private String author;

    @NotEmpty(message = " category should not be empty")
    @Column(columnDefinition = "varchar(20) not null check (category='Academic' or category='Mystery' or category='Novel')")
    private String category; // (check Academic or Mystery or Novel )


    @NotNull(message = "ISBN can not be empty")
    private Integer isbn;

    @Min(value = 50, message = "numberOfPages need to be more than 50")
    private Integer numberOfPages;// (min 50 pages)
}
