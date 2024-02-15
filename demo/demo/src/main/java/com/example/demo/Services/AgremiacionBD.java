package com.example.demo.Services;

import java.util.List;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Agremiacion;
import com.example.demo.Repository.IAgremiacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AgremiacionBD {
    
    @Autowired
    IAgremiacionRepository agremiacionRepository;

    public AgremiacionBD(){}

    public void persistir(Agremiacion agremiacion){
        agremiacionRepository.save(agremiacion);
    }

    /*public Integer ultimoCodigo(){
        List<Agremiacion> agremiaciones =(List<Agremiacion>)agremiacionRepository.findAll();
        System.out.println("antes de codigos");
        List<Integer> codigos=(List<Integer>) agremiaciones.stream().map(a->a.getCodigo());
        System.out.println("despues de codigos");
        OptionalInt maximo=codigos.stream().mapToInt(c->c).max();
        System.out.println("despues de max");
        if(maximo.isPresent()){
            return (Integer) maximo.getAsInt();
        }else{
            return 1;
        }
    }*/

    public Integer ultimoCodigo(){
        Integer codigo=agremiacionRepository.ultimoCodigo();
        if (codigo == null) {
            return 1;
        }
        return codigo;
    }
}
