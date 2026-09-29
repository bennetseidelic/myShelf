package com.github.bennetseidelic.myshelf.book;

import com.github.bennetseidelic.myshelf.book.requests.AddBookRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books/get/")
    public Iterable<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("books/add")
    public ResponseEntity<Book> addBook(@Valid @RequestBody AddBookRequest req) {
        Book book = bookService.addBook(req);
        return ResponseEntity.ok(book);
    }

}
