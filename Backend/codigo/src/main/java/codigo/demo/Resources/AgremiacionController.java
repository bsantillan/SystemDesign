package codigo.demo.Resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codigo.demo.Entities.Agremiacion;
import codigo.demo.Entities.Agremiado;
import codigo.demo.Services.AgremiacionBD;

@RestController
@RequestMapping("Agremiacion")
public class AgremiacionController {

    @Autowired
    AgremiacionBD agremiacionBD;

    public AgremiacionController(){}
    
    @PostMapping("/agremiar")
    public void agremiar(@RequestBody Agremiado agremiado){
        Agremiacion agremiacion=new Agremiacion();
        agremiacion.setOdontologo(agremiado);
        agremiacion.setCodigo(agremiacionBD.ultimoCodigo());
        agremiacion.setFechaDeAlta(new Date());
        agremiacion.cargarCuotas(agremiacion.crearCuotas());
        agremiacionBD.persistir(agremiacion);
    }
}
