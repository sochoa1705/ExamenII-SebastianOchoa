package ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto;

import ec.edu.espe.arquitectura.examen2sebastianochoa.model.Empleado;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmpresaRQ {
    private String ruc;
    private String razonSocial;
    private List<Empleado> empleados;
}
