package mk.ukim.finki.library_backend.model.dto;

import lombok.Data;
import mk.ukim.finki.library_backend.model.Author;
import mk.ukim.finki.library_backend.model.enumerations.Category;

import javax.persistence.*;

@Data
public class BookDto {

    private String name;

    private Category category;

    private Long author;

    private int availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
