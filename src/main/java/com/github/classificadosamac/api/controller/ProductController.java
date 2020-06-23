package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.dto.ProductDTO;
import com.github.classificadosamac.api.model.Product;
import com.github.classificadosamac.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> productSave(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> listHome() {
        return ResponseEntity.ok(productService.findAll(PageRequest.of(0, 4, Sort.by("id").descending())));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/page/{number}")
    public ResponseEntity<Page<ProductDTO>> list(@PathVariable int number) {
        return ResponseEntity.ok(productService.findAll(PageRequest.of(number, 16, Sort.by("id").descending())));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@RequestBody Product product, @PathVariable Long id) {
        return ResponseEntity.ok(productService.update(product, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok(null);
    }
}
