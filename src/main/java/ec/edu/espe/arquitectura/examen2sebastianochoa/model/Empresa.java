package ec.edu.espe.arquitectura.examen2sebastianochoa.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "empresa")
public class Empresa {
    @Id
    private String id;
    private String ruc;
    private String razonSocial;
    private List<Empleado> empleados;
}
