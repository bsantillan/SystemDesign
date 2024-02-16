package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Agremiado;
import com.example.demo.Entities.Consultorio;
import com.example.demo.Entities.Localidad;
import com.example.demo.Entities.Provincia;
import com.example.demo.Repository.IAgremiadoRepository;
import com.example.demo.Repository.IConsultorioRepository;
import com.example.demo.Repository.ILocalidadRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AgremiadoBD {
    @Autowired
    IAgremiadoRepository agremiadoRepository;
    @Autowired
    ILocalidadRepository localidadRepository;
    @Autowired
    IConsultorioRepository consultorioRepository;

    public AgremiadoBD(){}

    public Optional <Agremiado> findByDni(Integer dni){
        return agremiadoRepository.findByDni(dni);
    }

    public void persistir(Agremiado agremiado){
        agremiadoRepository.save(agremiado);
    }

    public List<Consultorio> buscarConsultorios(List<Consultorio> consultorios){
        List<Consultorio> consultoriosReales=new ArrayList<>();
        for(int i=0;i<consultorios.size();i++){
            Localidad localidadExistente=this.buscarLocalidad(consultorios.get(i).getLocalidad().getNombre());
            Consultorio consultorioExistente=this.buscarXCalleyNumeroyLocalidad(consultorios.get(i).getCalle(), consultorios.get(i).getNumero(),localidadExistente);
            consultoriosReales.add(consultorioExistente);
        }
        return consultoriosReales;
    }

    public Consultorio buscarXCalleyNumeroyLocalidad(String calle, String numero, Localidad localidad){
        return this.consultorioRepository.findByCalleAndNumeroAndLocalidad(calle, numero,localidad);
    }

    public Localidad buscarLocalidad(String nombre){
        return this.localidadRepository.findByNombre(nombre);
    }

    public Localidad buscarProvincia(Provincia provincia){
        return this.localidadRepository.findByProvincia(provincia);
    }
}
