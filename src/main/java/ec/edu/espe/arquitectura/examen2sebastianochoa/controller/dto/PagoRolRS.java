package ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto;

import ec.edu.espe.arquitectura.examen2sebastianochoa.model.EmpleadoPago;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class PagoRolRS {
    private String mes;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private BigDecimal valorTotal;
    private BigDecimal valorReal;
    private Integer totalTransacciones;
    private Integer errores;
}
