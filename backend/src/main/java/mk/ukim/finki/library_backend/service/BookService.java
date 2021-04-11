package mk.ukim.finki.library_backend.service;

import mk.ukim.finki.library_backend.model.Author;
import mk.ukim.finki.library_backend.model.Book;
import mk.ukim.finki.library_backend.model.dto.BookDto;
import mk.ukim.finki.library_backend.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();
    Optional<Book> addBook(BookDto bookDto);
    Optional<Book> deleteBook(Long id);
    Optional<Book> editBook(Long id,BookDto bookDto);
    Optional<Book> takeCopy(Long id);
    Optional<Book> findById(Long id);

}
