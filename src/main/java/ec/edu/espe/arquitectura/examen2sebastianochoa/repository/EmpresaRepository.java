package ec.edu.espe.arquitectura.examen2sebastianochoa.repository;

import ec.edu.espe.arquitectura.examen2sebastianochoa.model.Empleado;
import ec.edu.espe.arquitectura.examen2sebastianochoa.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    @Query(value = "{}", fields = "{'empleado': 1}")
    List<Empleado> findAllEmployees();
}
