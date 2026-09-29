package com.github.bennetseidelic.myshelf.book;

import com.github.bennetseidelic.myshelf.author.Author;
import com.github.bennetseidelic.myshelf.author.AuthorService;
import com.github.bennetseidelic.myshelf.book.requests.AddBookRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(AddBookRequest req) {
        Book book = new Book();
        Optional<Author> author = authorService.findByName(req.getAuthor());
        if (author.isEmpty()) {
            author = Optional.ofNullable(authorService.addAuthor(req.getAuthor()));
        }
        book.setAuthor(author.get());
        book.setTitle(req.getTitle());
        book.setPages(req.getPages());
        book.setStatus(BookStatus.UNREAD);

        book = bookRepository.save(book);
        return book;
    }
}
