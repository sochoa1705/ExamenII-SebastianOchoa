package ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto;

import ec.edu.espe.arquitectura.examen2sebastianochoa.model.EmpleadoPago;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class PagoRolRQ {
    private String mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private EmpleadoPago empleadoPago;
}
