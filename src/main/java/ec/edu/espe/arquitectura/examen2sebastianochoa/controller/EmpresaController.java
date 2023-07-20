package ec.edu.espe.arquitectura.examen2sebastianochoa.controller;

import ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen2sebastianochoa.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public ResponseEntity<?> crear(EmpresaRQ empresaRQ){
        this.empresaService.crearEmpresa(empresaRQ);
        return ResponseEntity.ok().build();
    }
}
