package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {
    @GetMapping
    public ResponseEntity<Produto> hello() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Bolo de maçã");
        produto.setPreco(30.0);
        produto.setDescricao("Sem glúten e sem leite");

        return ResponseEntity.ok(produto);
    }
}
