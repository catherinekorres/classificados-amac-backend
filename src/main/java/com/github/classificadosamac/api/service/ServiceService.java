package com.github.classificadosamac.api.service;

import com.github.classificadosamac.api.dto.ServiceDTO;
import com.github.classificadosamac.api.model.Service;
import com.github.classificadosamac.api.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.function.Function;


@org.springframework.stereotype.Service
public class ServiceService {
    // Singleton
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceDTO save(Service service) {
        serviceRepository.save(service);

        return new ServiceDTO(serviceRepository.save(service));
    }

    public Page<ServiceDTO> findAll(Pageable pageable) {
        Page<Service> services = serviceRepository.findAll(pageable);

        return services.map(new Function<Service, ServiceDTO>() {
            @Override
            public ServiceDTO apply(Service service) {

                return new ServiceDTO(service);
            }
        });
    }

    public Optional<ServiceDTO> findOne(Long id) {
        Optional<Service> service = serviceRepository.findById(id);

        return service.map(ServiceDTO::new);
    }

    public ServiceDTO update(Service service, Long id) {
        Optional<Service> optionalService = serviceRepository.findById(id);

        if (!optionalService.isPresent()) {
            return null;
        }

        service.setId(id);

        return this.save(service);
    }

    public void delete(Long id) {
        Optional<Service> optionalService = serviceRepository.findById(id);

        if (optionalService.isPresent()) {
            serviceRepository.deleteById(id);
        }
    }
}
