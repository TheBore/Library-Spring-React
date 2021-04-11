package mk.ukim.finki.library_backend.service;

import mk.ukim.finki.library_backend.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAllAuthors();

}
