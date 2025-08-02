package com.clubaccess.api.controller;

import com.clubaccess.api.dto.SocioDto;
import com.clubaccess.persistance.entity.SocioEntity;
import com.clubaccess.service.SocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @PostMapping
    public ResponseEntity<SocioEntity> crear(@RequestBody SocioDto dto) {
        return ResponseEntity.ok(socioService.crearSocio(dto));
    }

    @GetMapping
    public ResponseEntity<List<SocioEntity>> listar() {
        return ResponseEntity.ok(socioService.listarSocios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioEntity> obtener(@PathVariable Long id) {
        return socioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        socioService.eliminarSocio(id);
        return ResponseEntity.noContent().build();
    }
}
