package com.example.demo.Resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agremiacion;
import com.example.demo.Entities.Agremiado;
import com.example.demo.Services.AgremiacionBD;
import com.example.demo.Services.AgremiadoBD;


@RestController
@RequestMapping("/Agremiacion")
public class AgremiacionController {

    @Autowired
    AgremiacionBD agremiacionBD;
    @Autowired
    AgremiadoBD agremiadoBD;

    public AgremiacionController(){}
    
    @PostMapping("/agremiar")
    public ResponseEntity<Agremiacion> agremiar(@RequestBody Agremiado agremiado, String matricula){
        System.out.println("entre");
        Agremiado agremiadoReal = agremiadoBD.findByDni(agremiado.getDni()).get();
        Agremiacion agremiacion=new Agremiacion(matricula);
        System.out.println("antes de odontologo");
        agremiacion.setOdontologo(agremiadoReal);
        System.out.println("antes de codigo");
        agremiacion.setCodigo(agremiacionBD.ultimoCodigo()+1);
        System.out.println("antes de fecha");
        agremiacion.setFechaDeAlta(new Date());
        System.out.println("antes de matricula");
        //String matricula = agremiacion.getMatricula();
        //System.out.println(matricula);
        agremiacion.setMatricula(matricula);
        System.out.println(agremiacion.getMatricula());
        System.out.println("antes de crearCuotas");
        agremiacion.cargarCuotas(agremiacion.crearCuotas());
        System.out.println("antes de persistir agremiado");
        
        System.out.println("antes de persistir");
        agremiacionBD.persistir(agremiacion);
        System.out.println("antes de return");
        return ResponseEntity.ok(agremiacion);
    }

    @GetMapping("/hola")
    public String saludar(){
        return "hola";
    }
}
