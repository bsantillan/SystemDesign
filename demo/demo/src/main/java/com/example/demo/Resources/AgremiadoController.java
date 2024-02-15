package com.example.demo.Resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agremiacion;
import com.example.demo.Entities.Agremiado;
import com.example.demo.Entities.Consultorio;
import com.example.demo.Entities.ObraSocial;
import com.example.demo.Entities.DTO.AgremiadoDTO;
import com.example.demo.Entities.Enum.Estado;
import com.example.demo.Services.AgremiadoBD;

@RestController
@RequestMapping("/agremiado")
public class AgremiadoController {
    
    @Autowired
    AgremiadoBD agremiadoBD;

    public AgremiadoController(){}
    
    @PostMapping("/alta_agremiado")
    public ResponseEntity<Agremiado> alta_agremiado(@RequestBody AgremiadoDTO agremiadoDTO){
        System.out.println("entre");
        Agremiado agremiado=new Agremiado();
        agremiado.setApellido(agremiadoDTO.getApellido());
        agremiado.setDni(agremiadoDTO.getDni());
        agremiado.setEmail(agremiadoDTO.getEmail());
        agremiado.setEstado(Estado.Deudor);
        agremiado.setNombre(agremiadoDTO.getNombre());
        agremiado.setTelefono(agremiadoDTO.getTelefono());
        agremiado.setObraSocials(agremiadoDTO.getObraSocials());
        agremiado.setConsultorios(agremiadoDTO.getConsultorios());
        agremiadoBD.persistir(agremiado);
        System.out.println("antes de return");
        return ResponseEntity.ok(agremiado);
    }
}
