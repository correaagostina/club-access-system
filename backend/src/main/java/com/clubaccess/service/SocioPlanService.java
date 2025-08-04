package com.clubaccess.service;

import com.clubaccess.api.dto.SocioPlanDto;
import com.clubaccess.persistance.entity.PlanEntity;
import com.clubaccess.persistance.entity.SocioEntity;
import com.clubaccess.persistance.entity.SocioPlanEntity;
import com.clubaccess.persistance.repository.PlanRepository;
import com.clubaccess.persistance.repository.SocioPlanRepository;
import com.clubaccess.persistance.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
/**
 * Servicio para gestionar la asignación de planes a socios.
 */

@Service
public class SocioPlanService {

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private SocioPlanRepository socioPlanRepository;

    public void asignarPlanASocio(SocioPlanDto dto) {
        SocioEntity socio = socioRepository.findById(dto.getSocioId()).orElseThrow();
        PlanEntity plan = planRepository.findById(dto.getPlanId()).orElseThrow();

        SocioPlanEntity entidad = new SocioPlanEntity();
        entidad.setSocio(socio);
        entidad.setPlan(plan);
        entidad.setFechaInicio(dto.getFechaInicio());
        entidad.setFechaFin(dto.getFechaFin());

        socioPlanRepository.save(entidad);
    }
    public void actualizarPlanDeSocio(Long socioId, Long planId, SocioPlanDto dto) {
        SocioPlanEntity entidad = socioPlanRepository.findBySocioIdAndPlanId(socioId, planId)
                .orElseThrow(() -> new RuntimeException("No se encontró la relación entre el socio y el plan"));
        entidad.setFechaInicio(dto.getFechaInicio());
        entidad.setFechaFin(dto.getFechaFin());
        socioPlanRepository.save(entidad);
    }
    public void eliminarPlanDeSocio(Long socioId, Long planId) {
        SocioPlanEntity entidad = socioPlanRepository.findBySocioIdAndPlanId(socioId, planId)
                .orElseThrow(() -> new RuntimeException("No se encontró la relación entre el socio y el plan"));
        socioPlanRepository.delete(entidad);
    }
    public SocioPlanDto obtenerPlanDeSocio(Long socioId, Long planId) {
        SocioPlanEntity entidad = socioPlanRepository.findBySocioIdAndPlanId(socioId, planId)
                .orElseThrow(() -> new RuntimeException("No se encontró la relación entre el socio y el plan"));
        return new SocioPlanDto(
                entidad.getSocio().getId(),
                entidad.getPlan().getId(),
                entidad.getFechaInicio(),
                entidad.getFechaFin()
        );
    }
    public List<SocioPlanDto> listarPlanesDeSocio(Long socioId) {
        return socioPlanRepository.findBySocioId(socioId).stream()
                .map(entidad -> new SocioPlanDto(
                        entidad.getSocio().getId(),
                        entidad.getPlan().getId(),
                        entidad.getFechaInicio(),
                        entidad.getFechaFin()
                ))
                .collect(Collectors.toList());
    }

}
