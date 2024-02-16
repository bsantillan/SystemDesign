package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Consultorio;
import com.example.demo.Repository.IConsultorioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsultorioBD {
    
    @Autowired
    IConsultorioRepository consultorioRepository;

    public List<Consultorio> listarConsultorios(){
        return (List<Consultorio>) this.consultorioRepository.findAll();
    }
}
