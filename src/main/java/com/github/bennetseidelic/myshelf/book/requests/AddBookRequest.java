package com.github.bennetseidelic.myshelf.book.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AddBookRequest {
    @NotBlank(message = "Author must not be empty")
    private String author;
    @NotBlank(message = "Title must not be empty")
    private String title;
    @Min(value = 1, message = "Pages must at least be 1")
    private int pages;

    public AddBookRequest(String author, String title, int pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public AddBookRequest() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
