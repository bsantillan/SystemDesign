package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Consultorio;
import com.example.demo.Entities.Localidad;

@Repository
public interface IConsultorioRepository extends CrudRepository<Consultorio,Integer>{
    
    public Consultorio findByCalleAndNumeroAndLocalidad(String calle,String numero,Localidad localidad);

    public Localidad findByLocalidad(Localidad localidad);


}
