package com.example.exerciswek4.Controller;

import com.example.exerciswek4.Model.Book;
import com.example.exerciswek4.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getAllBook() {
        List<Book> books = bookService.getAllBook();
        return ResponseEntity.status(200).body(books);

    }

    @PostMapping("/add")
    public ResponseEntity AddBook(@RequestBody @Valid Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(200).body("book added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody Book book, @Valid @PathVariable Integer id) {

        bookService.updateBook(book, id);
return ResponseEntity.status(200).body("book updated");

    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteBook(@Valid@PathVariable Integer id ){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book delete");

    }
    @GetMapping("/get-category/{category}")
    public ResponseEntity findBookByCategory(@Valid@PathVariable String category){
        List<Book>books=bookService.findBookByCategory(category);
        return ResponseEntity.status(200).body(books);

    }
    @GetMapping("/book-pagenumber")
    public ResponseEntity findBooksOver300(){

        List<Book> books=bookService.findBooksOver300();
        return ResponseEntity.status(200).body(books);

    }
    @GetMapping("/get-author/{author}")
    public ResponseEntity findBookByAuthor(@Valid@PathVariable String author){
        List<Book>books=bookService.findBookByAuthor(author);
        return ResponseEntity.status(200).body(books);

    }
    @GetMapping("/get-title/{title}")
    public ResponseEntity findBookByTitle(@Valid @PathVariable String title){
        List<Book>books=bookService.findBookByTitle(title);
        return ResponseEntity.status(200).body(books);

    }

}
