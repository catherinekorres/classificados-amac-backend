package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        product1.setId(1L);
        product1.setName("Bolo de maçã");
        product1.setPrice(30.0);
        product1.setDescription("Sem glúten e sem leite");

        product2.setId(2L);
        product2.setName("Empanadas");
        product2.setPrice(5.0);
        product2.setDescription("Diversos sabores");

        product3.setId(3L);
        product3.setName("Docinhos");
        product3.setPrice(2.0);
        product3.setDescription("Brigadeiro, beijinho e leite ninho");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return ResponseEntity.ok(productList);
    }
}
