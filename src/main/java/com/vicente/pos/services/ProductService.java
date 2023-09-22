package com.vicente.pos.services;

import com.vicente.pos.models.ProductModel;
import com.vicente.pos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> getAllProducts() {

        return productRepository.findAll();
    }

    public ProductModel getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void createProduct(ProductModel product){
        productRepository.save(product);
    }

    public boolean deleteProductById(int id) {

        if (productRepository.existsById(id)) {

            productRepository.deleteById(id);
            return true;
        }

        return false;
    }
    public void updateProduct(ProductModel product) {
        productRepository.save(product);
    }


}