package codigo.demo.Services;

import java.util.List;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codigo.demo.Entities.Agremiacion;
import codigo.demo.Repository.IAgremiacionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AgremiacionBD {
    
    @Autowired
    IAgremiacionRepository agremiacionRepository;

    public AgremiacionBD(){}

    public void persistir(Agremiacion agremiacion){
        agremiacionRepository.save(agremiacion);
    }

    public Integer ultimoCodigo(){
        List<Agremiacion> agremiaciones =(List<Agremiacion>)agremiacionRepository.findAll();
        List<Integer> codigos=(List<Integer>) agremiaciones.stream().map(a->a.getCodigo());
        OptionalInt maximo=codigos.stream().mapToInt(c->c).max();
        if(maximo.isPresent()){
            return (Integer) maximo.getAsInt();
        }else{
            return 1;
        }
    }
}
