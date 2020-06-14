package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.model.Support;
import com.github.classificadosamac.api.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/support")
public class SupportController {
    private final SupportService supportService;

    @Autowired
    public SupportController(SupportService supportService){
        this.supportService = supportService;

    }

    @PostMapping
    public ResponseEntity<Support> supportSave(@RequestBody Support support){
        return ResponseEntity.ok(supportService.save(support));

    }

    @GetMapping
    public ResponseEntity<List<Support>> list(){
        return ResponseEntity.ok(supportService.findAll());


    }

    @GetMapping("/{id}")
    public ResponseEntity<Support> findById(@PathVariable Long id){
        return ResponseEntity.ok(supportService.findOne(id));


    }
}
