package mk.ukim.finki.library_backend.web.rest;

import mk.ukim.finki.library_backend.model.Book;
import mk.ukim.finki.library_backend.model.dto.BookDto;
import mk.ukim.finki.library_backend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping ("/get-book/{id}")
    private Book getBook(@PathVariable Long id){
        return this.bookService.findById(id).get();
    }

    @GetMapping
    private List<Book> findAllBooks(){
        List<Book> tmp = this.bookService.findAll();
        return tmp;
    }

    @PostMapping("/add")
    private ResponseEntity<Book> addBook(@RequestBody BookDto bookDto){
        return this.bookService.addBook(bookDto).
                map(book -> ResponseEntity.ok().body(book)).
                orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Book> deleteBook(@PathVariable Long id){
        this.bookService.deleteBook(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    private ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.editBook(id,bookDto).
                map(book -> ResponseEntity.ok().body(book)).
                orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/take-copy/{id}")
    private ResponseEntity<Book> takeCopyBook(@PathVariable Long id){
        return this.bookService.takeCopy(id).
                map(book -> ResponseEntity.ok().body(book)).
                orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
