package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.model.Product;
import com.github.classificadosamac.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> productSave(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<Page<Product>> listHome() {
        return ResponseEntity.ok(productService.findAll(PageRequest.of(0, 4)));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/page/{number}")
    public ResponseEntity<Page<Product>> list(@PathVariable int number) {
        return ResponseEntity.ok(productService.findAll(PageRequest.of(number, 24)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> productUpdate(@RequestBody Product product, @PathVariable Long id) {
        return ResponseEntity.ok(productService.update(product, id));
    }
}
