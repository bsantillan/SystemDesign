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
import com.example.demo.Services.ConsultorioBD;
import com.example.demo.Services.ObraSocialBD;

@RestController
@RequestMapping("/agremiado")
public class AgremiadoController {
    
    @Autowired
    AgremiadoBD agremiadoBD;
    @Autowired
    ConsultorioBD consultorioBD;
    @Autowired
    ObraSocialBD obraSocialBD;

    public AgremiadoController(){}
    
    @PostMapping("/alta_agremiado")
    public ResponseEntity<Agremiado> alta_agremiado(@RequestBody AgremiadoDTO agremiadoDTO){
        Agremiado agremiado=new Agremiado();
        if(this.agremiadoBD.findByDni(agremiadoDTO.getDni()).isEmpty()){
            agremiado.setDni(agremiadoDTO.getDni());
            agremiado.setApellido(agremiadoDTO.getApellido());
            agremiado.setEmail(agremiadoDTO.getEmail());
            agremiado.setEstado(Estado.Deudor);
            agremiado.setNombre(agremiadoDTO.getNombre());
            agremiado.setTelefono(agremiadoDTO.getTelefono());
            agremiado.setObraSocials(obraSocialBD.buscarObrasSociales(agremiadoDTO.getObraSocials()));
            agremiado.setConsultorios(consultorioBD.buscarConsultorios(agremiadoDTO.getConsultorios()));
            agremiadoBD.persistir(agremiado);
            return ResponseEntity.ok(agremiado);
        }else{
            return ResponseEntity.ok(agremiado);
        }
    }
}
