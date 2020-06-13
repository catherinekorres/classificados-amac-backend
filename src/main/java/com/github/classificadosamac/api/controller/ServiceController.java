package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.model.Service;
import com.github.classificadosamac.api.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ResponseEntity<Service> serviceSave(@RequestBody Service service) {
        return ResponseEntity.ok(serviceService.save(service));
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Service>> list() {
        return ResponseEntity.ok(serviceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> findById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> serviceUpdate(@RequestBody Service service, @PathVariable Long id) {
        return ResponseEntity.ok(serviceService.update(service, id));
    }

}
