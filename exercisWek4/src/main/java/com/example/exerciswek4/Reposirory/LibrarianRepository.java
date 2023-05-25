package com.example.exerciswek4.Reposirory;

import com.example.exerciswek4.Model.Book;
import com.example.exerciswek4.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

    public Librarian findLibrarianById(Integer id);

    public Librarian findLibrarianByUsernameAndPassword(String username,String password);
    public Librarian findLibrarianByEmail(String email);
}
