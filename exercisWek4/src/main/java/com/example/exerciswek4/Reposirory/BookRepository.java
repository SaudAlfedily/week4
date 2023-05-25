package com.example.exerciswek4.Reposirory;

import com.example.exerciswek4.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public Book findBookById(Integer id);

    public List<Book> findBookByCategory(String category);

    List<Book> findBookByNumberOfPagesGreaterThanEqual(Integer pages);
    public List<Book> findBookByAuthor(String author);

    public List<Book> findBookByTitle(String title);

}
