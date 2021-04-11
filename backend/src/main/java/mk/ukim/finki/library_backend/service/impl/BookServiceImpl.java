package mk.ukim.finki.library_backend.service.impl;

import mk.ukim.finki.library_backend.model.Author;
import mk.ukim.finki.library_backend.model.Book;
import mk.ukim.finki.library_backend.model.dto.BookDto;
import mk.ukim.finki.library_backend.model.enumerations.Category;
import mk.ukim.finki.library_backend.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.library_backend.model.exceptions.BookNotFoundException;
import mk.ukim.finki.library_backend.repository.AuthorRepository;
import mk.ukim.finki.library_backend.repository.BookRepository;
import mk.ukim.finki.library_backend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> addBook(BookDto bookDto) {
        Author author = authorRepository.
                findById(bookDto.getAuthor()).
                orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> deleteBook(Long id) {
        Book book = bookRepository.
                findById(id).orElseThrow(() -> new BookNotFoundException(id));
        this.bookRepository.delete(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> editBook(Long id, BookDto bookDto) {
        Book book = bookRepository.
                findById(id).
                orElseThrow(() -> new BookNotFoundException(id));

        Author author = authorRepository.
                findById(bookDto.getAuthor()).
                orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setName(book.getName());
        book.setCategory(book.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(book.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> takeCopy(Long id) {
        Book book = bookRepository.
                findById(id).
                orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies() > 0)
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }
}
