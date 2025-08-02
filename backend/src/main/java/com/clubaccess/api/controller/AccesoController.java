package com.clubaccess.api.controller;

import com.clubaccess.api.dto.AccesoDto;
import com.clubaccess.persistance.entity.AccesoEntity;
import com.clubaccess.service.AccesoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accesos")
public class AccesoController {

    private final AccesoService accesoService;

    public AccesoController(AccesoService accesoService) {
        this.accesoService = accesoService;
    }

    @PostMapping
    public ResponseEntity<AccesoEntity> registrar(@RequestBody AccesoDto dto) {
        return ResponseEntity.ok(accesoService.registrarAcceso(dto));
    }

    @GetMapping
    public ResponseEntity<List<AccesoEntity>> listar() {
        return ResponseEntity.ok(accesoService.listarAccesos());
    }

    @GetMapping("/socio/{id}")
    public ResponseEntity<List<AccesoEntity>> porSocio(@PathVariable Long id) {
        return ResponseEntity.ok(accesoService.accesosPorSocio(id));
    }
}
