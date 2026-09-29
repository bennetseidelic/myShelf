package com.github.bennetseidelic.myshelf.book;

import com.github.bennetseidelic.myshelf.author.Author;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    @Column
    private int pages;

    @Column(nullable = false)
    private BookStatus status;

    public Book() {
    }

    public Book(String title, Author author, int pages, BookStatus status) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.status = status;
    }
}
