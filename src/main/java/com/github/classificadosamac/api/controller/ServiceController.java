package com.github.classificadosamac.api.controller;

import com.github.classificadosamac.api.dto.ServiceDTO;
import com.github.classificadosamac.api.model.Service;
import com.github.classificadosamac.api.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ResponseEntity<ServiceDTO> productSave(@RequestBody Service service) {
        return ResponseEntity.ok(serviceService.save(service));
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<Page<ServiceDTO>> listHome() {
        return ResponseEntity.ok(serviceService.findAll(PageRequest.of(0, 4, Sort.by("id").descending())));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/page/{number}")
    public ResponseEntity<Page<ServiceDTO>> list(@PathVariable int number) {
        return ResponseEntity.ok(serviceService.findAll(PageRequest.of(number, 16, Sort.by("id").descending())));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ServiceDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDTO> update(@RequestBody Service service, @PathVariable Long id) {
        return ResponseEntity.ok(serviceService.update(service, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        serviceService.delete(id);
        return ResponseEntity.ok(null);
    }

}
