package ec.edu.espe.arquitectura.examen2sebastianochoa.service;

import ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto.EmpleadoRQ;
import ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen2sebastianochoa.model.Empleado;
import ec.edu.espe.arquitectura.examen2sebastianochoa.model.Empresa;
import ec.edu.espe.arquitectura.examen2sebastianochoa.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public void crearEmpresa(EmpresaRQ rq){
        try{
            Empresa empresa = transformEmpresaRQ(rq);
            this.empresaRepository.save(empresa);
        }catch (RuntimeException rte){
            throw new RuntimeException("Error al crear la empresa");
        }
    }


    public Empresa transformEmpresaRQ(EmpresaRQ rq){
        Empresa empresa = Empresa
                .builder()
                .ruc(rq.getRuc())
                .razonSocial(rq.getRazonSocial())
                .empleados(rq.getEmpleados())
                .build();
        return empresa;
    }


}
