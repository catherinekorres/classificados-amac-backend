package com.github.classificadosamac.api.repository;

import com.github.classificadosamac.api.model.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service, Long> {
}
