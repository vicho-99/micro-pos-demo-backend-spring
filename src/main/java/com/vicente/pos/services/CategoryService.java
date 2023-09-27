package com.vicente.pos.services;

import com.vicente.pos.models.CategoryModel;
import com.vicente.pos.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategorys() {

        return categoryRepository.findAll(Sort.by("created").descending());
    }

    public CategoryModel getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void createCategory(CategoryModel product){
        categoryRepository.save(product);
    }

    public boolean deleteCategoryById(int id) {
        if (categoryRepository.existsById(id)) {

            categoryRepository.deleteById(id);
            return true;
        }

        return false;
    }
    public void updateCategory(CategoryModel product) {
        categoryRepository.save(product);
    }

}
