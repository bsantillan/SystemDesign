package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Agremiado;
import com.example.demo.Repository.IAgremiadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AgremiadoBD {
    @Autowired
    IAgremiadoRepository agremiadoRepository;

    public AgremiadoBD(){}

    public Optional <Agremiado> findByDni(Integer dni){
        return agremiadoRepository.findByDni(dni);
    }

    public void persistir(Agremiado agremiado){
        agremiadoRepository.save(agremiado);
    }

}
