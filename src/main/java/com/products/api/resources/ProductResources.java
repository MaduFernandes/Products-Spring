package com.products.api.resources;

import com.products.api.models.Product;
import com.products.api.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Product API REST")
@CrossOrigin(origins = "*")
public class ProductResources {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value = "Return Products List")
    public List<Product> ListProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    @ApiOperation(value = "List a Single Product")
    public Product getProduct(@PathVariable(value = "id") long id) {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    @ApiOperation(value = "Save a Product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    @ApiOperation(value = "Delete a Product")
    public void deleteProduct(@RequestBody Product product) {
        productRepository.delete(product);
    }

    @PutMapping("/product")
    @ApiOperation(value = "Update a Product")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
