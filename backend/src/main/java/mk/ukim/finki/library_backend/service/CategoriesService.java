package mk.ukim.finki.library_backend.service;

import mk.ukim.finki.library_backend.model.enumerations.Category;

import java.util.List;

public interface CategoriesService {

    List<Category> findAllCategories();

}
