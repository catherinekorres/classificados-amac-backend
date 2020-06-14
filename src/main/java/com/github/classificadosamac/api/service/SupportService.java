package com.github.classificadosamac.api.service;

import com.github.classificadosamac.api.model.Support;
import com.github.classificadosamac.api.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportService {
    private final SupportRepository supportRepository;

    @Autowired
    public SupportService(SupportRepository supportRepository){this.supportRepository = supportRepository;}

    public Support save(Support support){
        return supportRepository.save(support);
    }

    public List <Support> findAll(){
        return supportRepository.findAll();
    }

    public Support findOne(Long id){
        return supportRepository.findById(id).orElse(null);


    }
}
