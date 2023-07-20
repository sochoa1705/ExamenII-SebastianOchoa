package ec.edu.espe.arquitectura.examen2sebastianochoa.repository;

import ec.edu.espe.arquitectura.examen2sebastianochoa.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    
}
