package codigo.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import codigo.demo.Entities.Agremiacion;

@Repository
public interface IAgremiacionRepository extends CrudRepository<Agremiacion,Integer>{
}
