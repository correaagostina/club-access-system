package com.clubaccess.persistance.entity;

import com.clubaccess.persistance.entity.PlanEntity;
import com.clubaccess.persistance.entity.SocioEntity;  
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import com.clubaccess.persistance.entity.SocioPlanId;

/** * Entidad que representa la relación entre un socio y un plan.
 * Esta entidad permite asociar un socio a un plan específico, incluyendo las fechas de inicio y fin de la asociación.
 */ 

@Entity
@Table(name = "socios_planes")
@IdClass(SocioPlanId.class)
public class SocioPlanEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private SocioEntity socio;

    @Id
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PlanEntity plan;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public SocioEntity getSocio() {
        return socio;
    }

    public void setSocio(SocioEntity socio) {
        this.socio = socio;
    }

    public PlanEntity getPlan() {
        return plan;
    }

    public void setPlan(PlanEntity plan) {
        this.plan = plan;
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
