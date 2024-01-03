package codigo.demo.Services;

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

    public int ultimoCodigo(){
        return agremiacionRepository.ultimocodigo();
    }
}
