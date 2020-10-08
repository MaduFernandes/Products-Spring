package com.products.api.resources;

import com.products.api.models.Product;
import com.products.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductResources {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> ListProduct() {
        return productRepository.findAll();
    }
}
