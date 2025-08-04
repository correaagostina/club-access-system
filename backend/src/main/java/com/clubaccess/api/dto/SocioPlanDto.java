package com.clubaccess.api.dto;

import java.time.LocalDate;

public class SocioPlanDto {
    private Long socioId;
    private Long planId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    public SocioPlanDto() { 

    }
    public SocioPlanDto(Long socioId, Long planId, LocalDate fechaInicio, LocalDate fechaFin) {
        this.socioId = socioId;
        this.planId = planId;   
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    public SocioPlanDto(Long socioId, Long planId) {
        this.socioId = socioId;
        this.planId = planId;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now().plusDays(30); // Default to 30 days from now
    }
    public SocioPlanDto(Long socioId, Long planId, LocalDate fechaInicio) {
        this.socioId = socioId;
        this.planId = planId;   
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaInicio.plusDays(30); // Default to 30 days from start date
    }
    public Long getSocioId() {  
        return socioId;
    }
    public void setSocioId(Long socioId) {
        this.socioId = socioId;
    }
    public Long getPlanId() {
        return planId;
    }
    public void setPlanId(Long planId) {
        this.planId = planId;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    
}
