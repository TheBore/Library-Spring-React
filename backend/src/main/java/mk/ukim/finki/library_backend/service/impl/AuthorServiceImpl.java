package mk.ukim.finki.library_backend.service.impl;

import mk.ukim.finki.library_backend.model.Author;
import mk.ukim.finki.library_backend.repository.AuthorRepository;
import mk.ukim.finki.library_backend.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
}
