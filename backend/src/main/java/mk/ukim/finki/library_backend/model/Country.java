package mk.ukim.finki.library_backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    @OneToMany(mappedBy = "country")
    private List<Author> authors;

    public Country() {
    }

    public Country(String name, String continent, List<Author> authors) {
        this.name = name;
        this.continent = continent;
        this.authors = authors;
    }
}
