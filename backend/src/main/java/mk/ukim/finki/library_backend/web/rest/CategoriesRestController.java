package mk.ukim.finki.library_backend.web.rest;

import mk.ukim.finki.library_backend.model.enumerations.Category;
import mk.ukim.finki.library_backend.service.CategoriesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesRestController {

    private final CategoriesService categoriesService;

    public CategoriesRestController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    private List<Category> findAllCategories(){
        return this.categoriesService.findAllCategories();
    }

}
