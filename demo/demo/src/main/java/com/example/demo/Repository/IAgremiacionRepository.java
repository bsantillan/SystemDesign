package com.example.demo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Agremiacion;

@Repository
public interface IAgremiacionRepository extends CrudRepository<Agremiacion,Integer>{
    @Query(value = "select MAX(codigo) from agremiacion;", nativeQuery = true)
    Integer ultimoCodigo();
}
