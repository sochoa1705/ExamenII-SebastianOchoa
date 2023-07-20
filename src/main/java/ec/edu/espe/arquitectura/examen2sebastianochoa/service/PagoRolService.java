package ec.edu.espe.arquitectura.examen2sebastianochoa.service;

import ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto.PagoRolRS;
import ec.edu.espe.arquitectura.examen2sebastianochoa.model.EmpleadoPago;
import ec.edu.espe.arquitectura.examen2sebastianochoa.model.PagoRol;
import ec.edu.espe.arquitectura.examen2sebastianochoa.repository.EmpresaRepository;
import ec.edu.espe.arquitectura.examen2sebastianochoa.repository.PagoRolRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagoRolService {
    private final PagoRolRepository pagoRolRepository;
    private final EmpresaRepository empresaRepository;

    public PagoRolService(PagoRolRepository pagoRolRepository, EmpresaRepository empresaRepository) {
        this.pagoRolRepository = pagoRolRepository;
        this.empresaRepository = empresaRepository;
    }

    public void crearPagoRol(PagoRolRQ rq){
        try{
            PagoRol pagoRol = transformPagoRolRQ(rq);
            List<PagoRol> pagoRolList = this.pagoRolRepository.findAllEmployees();
            Integer pagosCounter = 0;
            for (PagoRol pagos: pagoRolList){
                pagosCounter = pagosCounter + pagos.getEmpleadoPago().getValor().intValue();
            }
            pagoRol.setValorTotal(BigDecimal.valueOf(pagosCounter));
            pagoRol.setValorReal(BigDecimal.valueOf(0.0));
            pagoRol.getEmpleadoPago().setEstado("PEN");
            this.pagoRolRepository.save(pagoRol);
        }catch (RuntimeException rte){
            throw new RuntimeException("Error al crear el pago rol");
        }
    }


    public PagoRolRS validarPagoRol(String mes, String rucEmpresa){
        try{
            List<PagoRol> pagoRolList = this.pagoRolRepository.findAllEmployees();
            Integer pagosCounter = 0;
            for (PagoRol pagos: pagoRolList){
                if (pagos.getMes().equals(mes) && pagos.getRucEmpresa().equals(rucEmpresa)){
                    pagosCounter = pagosCounter + pagos.getEmpleadoPago().getValor().intValue();
                    pagos.getEmpleadoPago().setEstado("VAL");
                }else{
                    pagos.getEmpleadoPago().setEstado("BAD");
                }
            }
            pagoRolList.get(0).setValorReal(BigDecimal.valueOf(pagosCounter));
            this.pagoRolRepository.saveAll(pagoRolList);
        }catch (RuntimeException rte){
            throw new RuntimeException("Error al validar el pago rol");
        }
    }

    public PagoRol transformPagoRolRQ(PagoRolRQ rq){
        PagoRol pagoRol = PagoRol
                .builder()
                .mes(rq.getMes())
                .rucEmpresa(rq.getRucEmpresa())
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .empleadoPago(rq.getEmpleadoPago())
                .build();
        return pagoRol;
    }

    public EmpleadoPago transformEmpleadoPagoRQ(EmpleadoPago rq){
        EmpleadoPago empleadoPago = EmpleadoPago
                .builder()
                .numeroCuenta(rq.getNumeroCuenta())
                .valor(rq.getValor())
                .build();
        return empleadoPago;
    }



}
