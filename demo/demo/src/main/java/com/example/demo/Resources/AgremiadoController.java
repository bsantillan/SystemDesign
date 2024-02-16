package com.example.demo.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agremiado;
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
        if(this.agremiadoBD.findByDni(agremiadoDTO.getDni()).isEmpty()){
            agremiado.setDni(agremiadoDTO.getDni());
            agremiado.setApellido(agremiadoDTO.getApellido());
            agremiado.setEmail(agremiadoDTO.getEmail());
            agremiado.setEstado(Estado.Deudor);
            agremiado.setNombre(agremiadoDTO.getNombre());
            agremiado.setTelefono(agremiadoDTO.getTelefono());
            System.out.println("antes de obraSocial");
            agremiado.setObraSocials(agremiadoDTO.getObraSocials());
            System.out.println("antes de consultorios");
            agremiado.setConsultorios(agremiadoBD.buscarConsultorios(agremiadoDTO.getConsultorios()));
            System.out.println("antes de persistir");
            agremiadoBD.persistir(agremiado);
            System.out.println("antes de return");
            return ResponseEntity.ok(agremiado);
        }else{
            return ResponseEntity.ok(agremiado);
        }
    }
}
