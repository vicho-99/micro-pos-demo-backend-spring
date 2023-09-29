package com.vicente.pos.controllers;

import com.vicente.pos.models.CategoryModel;
import com.vicente.pos.models.Response;
import com.vicente.pos.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categorys")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/")
    public List<CategoryModel> getAllCategory() {
        return categoryService.getAllCategory();
    }
    @PostMapping("/")
    public ResponseEntity<Response> createCategory(@RequestBody CategoryModel category){
        categoryService.createCategory(category);
        return Response.res("Successfully created", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCategory(@PathVariable int id){
        boolean deleted = categoryService.deleteCategoryById(id);
        if (deleted)
            return Response.res("successful removal",HttpStatus.OK);
        else
            return Response.res("ID not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public CategoryModel getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @PutMapping("/")
    public ResponseEntity<Response>  updateCategory(@RequestBody CategoryModel category){
        categoryService.updateCategory(category);
        return Response.res("Successfully update",HttpStatus.OK);
    }
}
