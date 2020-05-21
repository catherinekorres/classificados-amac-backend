package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class Hello {

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtoList = new ArrayList<>();
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();

        produto1.setId(1L);
        produto1.setNome("Bolo de maçã");
        produto1.setPreco(30.0);
        produto1.setDescricao("Sem glúten e sem leite");

        produto2.setId(2L);
        produto2.setNome("Empanadas");
        produto2.setPreco(5.0);
        produto2.setDescricao("Diversos sabores");

        produto3.setId(3L);
        produto3.setNome("Docinhos");
        produto3.setPreco(2.0);
        produto3.setDescricao("Brigadeiro, beijinho e leite ninho");

        produtoList.add(produto1);
        produtoList.add(produto2);
        produtoList.add(produto3);

        return ResponseEntity.ok(produtoList);
    }
}
