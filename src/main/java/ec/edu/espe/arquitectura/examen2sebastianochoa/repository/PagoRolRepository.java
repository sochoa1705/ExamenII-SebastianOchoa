package ec.edu.espe.arquitectura.examen2sebastianochoa.repository;

import ec.edu.espe.arquitectura.examen2sebastianochoa.model.PagoRol;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PagoRolRepository extends MongoRepository<PagoRol, String > {
    @Query(value = "{}", fields = "{'empleadoPago': 1}")
    List<PagoRol> findAllEmployees();
}
