package com.clubaccess.service;

import com.clubaccess.api.dto.PlanRequestDto;
import com.clubaccess.api.dto.PlanResponseDto;
import com.clubaccess.persistance.entity.PlanEntity;
import com.clubaccess.persistance.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
/** * Servicio para manejar las operaciones relacionadas con los planes.
 */

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public PlanResponseDto createPlan(PlanRequestDto dto) {
        PlanEntity plan = new PlanEntity();
        plan.setNombre(dto.getNombre());
        plan.setDescripcion(dto.getDescripcion());
        plan.setPrecio(dto.getPrecio());
        plan.setDuracionDias(dto.getDuracionDias());
        PlanEntity saved = planRepository.save(plan);
        return toDto(saved);
    }

    public List<PlanResponseDto> getAllPlans() {
        return planRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PlanResponseDto getPlan(Long id) {
        PlanEntity plan = planRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Plan not found"));
        return toDto(plan);
    }

    public PlanResponseDto updatePlan(Long id, PlanRequestDto dto) {
        PlanEntity plan = planRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Plan not found"));
        plan.setNombre(dto.getNombre());
        plan.setDescripcion(dto.getDescripcion());
        plan.setPrecio(dto.getPrecio());
        plan.setDuracionDias(dto.getDuracionDias());
        return toDto(planRepository.save(plan));
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }

    private PlanResponseDto toDto(PlanEntity entity) {
        PlanResponseDto dto = new PlanResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecio(entity.getPrecio());
        dto.setDuracionDias(entity.getDuracionDias());
        return dto;
    }
}
