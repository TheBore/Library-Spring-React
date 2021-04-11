package mk.ukim.finki.library_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import mk.ukim.finki.library_backend.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private int availableCopies;

    public Book() {

    }

    public Book(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
