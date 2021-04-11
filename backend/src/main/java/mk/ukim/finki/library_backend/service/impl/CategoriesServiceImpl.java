package mk.ukim.finki.library_backend.service.impl;

import mk.ukim.finki.library_backend.model.enumerations.Category;
import mk.ukim.finki.library_backend.service.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Override
    public List<Category> findAllCategories() {
        return Arrays.asList(Category.values());
    }
}
