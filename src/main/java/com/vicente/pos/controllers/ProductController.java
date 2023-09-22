package com.vicente.pos.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vicente.pos.models.ProductModel;
import com.vicente.pos.models.Response;
import com.vicente.pos.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/")
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/")
    public ResponseEntity<Response> createProduct(@RequestBody ProductModel product){
        productService.createProduct(product);
        return Response.res("Successfully created",HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable int id){
        boolean deleted = productService.deleteProductById(id);
        if (deleted)
            return Response.res("successful removal",HttpStatus.OK);
        else
            return Response.res("ID not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ProductModel getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @PutMapping("/")
    public ResponseEntity<Response>  updateProduct(@RequestBody ProductModel product){
        productService.updateProduct(product);
        return Response.res("Successfully update",HttpStatus.OK);
    }
}
