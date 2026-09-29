package com.github.bennetseidelic.myshelf.author;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    public Author addAuthor(String name) {
        return authorRepository.save(new Author(name));
    }
}
