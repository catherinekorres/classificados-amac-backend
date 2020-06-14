package com.github.classificadosamac.api.repository;

import com.github.classificadosamac.api.model.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support,Long> {
}
