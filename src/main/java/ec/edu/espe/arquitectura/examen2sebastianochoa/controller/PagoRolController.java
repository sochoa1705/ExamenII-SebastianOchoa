package ec.edu.espe.arquitectura.examen2sebastianochoa.controller;

import ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen2sebastianochoa.service.PagoRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pago-rol")
public class PagoRolController {
    private final PagoRolService pagoRolService;

    public PagoRolController(PagoRolService pagoRolService) {
        this.pagoRolService = pagoRolService;
    }


    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PagoRolRQ pagoRolRQ) {
        this.pagoRolService.crearPagoRol(pagoRolRQ);
        return ResponseEntity.ok().build();
    }

}
