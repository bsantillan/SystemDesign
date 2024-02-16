package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Localidad;
import com.example.demo.Repository.ILocalidadRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocalidadBD {
    
    @Autowired
    ILocalidadRepository localidadRepository;

    public List<Localidad>listarLocalidades(){
        return (List<Localidad>) this.localidadRepository.findAll();
    }
}
