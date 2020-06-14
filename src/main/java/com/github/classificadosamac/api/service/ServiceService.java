package com.github.classificadosamac.api.service;

import com.github.classificadosamac.api.model.Product;
import com.github.classificadosamac.api.model.Service;
import com.github.classificadosamac.api.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@org.springframework.stereotype.Service
public class ServiceService {
    // Singleton
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    public Service update(Service service, Long id) {
        Service updated = this.findOne(id);

        updated.setName(service.getName());
        updated.setDescription(service.getDescription());
        updated.setInvestment(service.getInvestment());

        return serviceRepository.save(updated);
    }

    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    public Service findOne(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}