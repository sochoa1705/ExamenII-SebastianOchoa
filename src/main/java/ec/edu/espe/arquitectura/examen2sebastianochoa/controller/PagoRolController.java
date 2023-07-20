package ec.edu.espe.arquitectura.examen2sebastianochoa.controller;

import ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen2sebastianochoa.controller.dto.PagoRolRS;
import ec.edu.espe.arquitectura.examen2sebastianochoa.service.PagoRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public ResponseEntity<PagoRolRS> validacion(@PathVariable String mes, @PathVariable String rucEmpresa) {
        PagoRolRS pagoRolRS = this.pagoRolService.validarPagoRol(mes, rucEmpresa);
        return ResponseEntity.ok(pagoRolRS);
    }


}
