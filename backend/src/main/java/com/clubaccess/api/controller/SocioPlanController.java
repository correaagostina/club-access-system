package com.clubaccess.api.controller;

import com.clubaccess.api.dto.SocioPlanDto;
import com.clubaccess.service.SocioPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador para manejar las asignaciones de planes a socios.
 */
import com.clubaccess.persistance.entity.SocioPlanEntity;
import com.clubaccess.persistance.repository.SocioPlanRepository;
import com.clubaccess.persistance.entity.PlanEntity;
import com.clubaccess.persistance.entity.SocioEntity;
import com.clubaccess.persistance.repository.PlanRepository;
import com.clubaccess.persistance.repository.SocioRepository;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/socios-planes")
public class SocioPlanController {

    @Autowired
    private SocioPlanService socioPlanService;

    @PostMapping
    public ResponseEntity<?> asignar(@RequestBody SocioPlanDto dto) {
        socioPlanService.asignarPlanASocio(dto);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{socioId}/{planId}")
    public ResponseEntity<?> actualizar(@PathVariable Long socioId, @PathVariable Long planId, @RequestBody SocioPlanDto dto) {
        socioPlanService.actualizarPlanDeSocio(socioId, planId, dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{socioId}/{planId}")
    public ResponseEntity<?> eliminar(@PathVariable Long socioId, @PathVariable Long planId) {
        socioPlanService.eliminarPlanDeSocio(socioId, planId);
        return ResponseEntity.noContent().build();
    }   
    @GetMapping("/{socioId}/{planId}")
    public ResponseEntity<SocioPlanDto> obtener(@PathVariable Long socioId, @PathVariable Long planId) {
        SocioPlanDto dto = socioPlanService.obtenerPlanDeSocio(socioId, planId);
        return ResponseEntity.ok(dto);
    }
}
