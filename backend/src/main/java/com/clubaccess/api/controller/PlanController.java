package com.clubaccess.api.controller;

import com.clubaccess.api.dto.PlanRequestDto;
import com.clubaccess.api.dto.PlanResponseDto;
import com.clubaccess.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.clubaccess.persistance.entity.PlanEntity;
import com.clubaccess.persistance.repository.PlanRepository;       
import com.clubaccess.persistance.repository.SocioRepository;

/**
 * Controlador para manejar las operaciones relacionadas con los planes.
 */

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping
    public ResponseEntity<PlanResponseDto> create(@RequestBody PlanRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.createPlan(dto));
    }

    @GetMapping
    public List<PlanResponseDto> getAll() {
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(planService.getPlan(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanResponseDto> update(@PathVariable Long id, @RequestBody PlanRequestDto dto) {
        return ResponseEntity.ok(planService.updatePlan(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        planService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
