package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Localidad;
import com.example.demo.Entities.Provincia;

@Repository
public interface ILocalidadRepository extends CrudRepository<Localidad,Integer>{
    
    public Localidad findByNombre(String nombre);
    
    public Localidad findByProvincia(Provincia provincia);
}
