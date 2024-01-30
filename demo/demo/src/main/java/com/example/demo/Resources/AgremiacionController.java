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


@RestController
@RequestMapping("/Agremiacion")
public class AgremiacionController {

    @Autowired
    AgremiacionBD agremiacionBD;

    public AgremiacionController(){}
    
    @PostMapping("/agremiar")
    public ResponseEntity<Agremiacion> agremiar(@RequestBody Agremiado agremiado){
        Agremiacion agremiacion=new Agremiacion();
        agremiacion.setOdontologo(agremiado);
        agremiacion.setCodigo(agremiacionBD.ultimoCodigo()+1);
        agremiacion.setFechaDeAlta(new Date());
        agremiacion.cargarCuotas(agremiacion.crearCuotas());
        agremiacionBD.persistir(agremiacion);
        return ResponseEntity.ok(agremiacion);
    }

    @GetMapping("/hola")
    public String saludar(){
        return "hola";
    }
}
