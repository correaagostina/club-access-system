package com.clubaccess.persistance.entity;

import com.clubaccess.persistance.entity.SocioEntity;
import com.clubaccess.persistance.entity.PlanEntity;
import com.clubaccess.api.dto.SocioDto;
import com.clubaccess.persistance.entity.SocioPlanEntity;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.IdClass;


/** * Clase que representa la clave primaria compuesta para la entidad SocioPlanEntity.
 * Esta clase es utilizada para identificar de manera única la relación entre un socio y un plan.
 * Implementa Serializable para permitir su uso en operaciones de persistencia.
 */
@IdClass(SocioPlanId.class)

public class SocioPlanId implements Serializable {
    private Long socio;
    private Long plan;

    public SocioPlanId() {
    } 
    public SocioPlanId(Long socio, Long plan) {
        this.socio = socio;
        this.plan = plan;
    }
    public Long getSocio() {
        return socio;
    }
    public void setSocio(Long socio) {
        this.socio = socio;
    }
    public Long getPlan() {
        return plan;
    }
    public void setPlan(Long plan) {
        this.plan = plan;
    }   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocioPlanId)) return false;
        SocioPlanId that = (SocioPlanId) o;
        return Objects.equals(socio, that.socio) && Objects.equals(plan, that.plan);
    }
    @Override
    public int hashCode() {
        return Objects.hash(socio, plan);
    }   
    @Override
    public String toString() {
        return "SocioPlanId{" +
                "socio=" + socio +
                ", plan=" + plan +
                '}';
    }
    public static SocioPlanId of(Long socio, Long plan) {
        return new SocioPlanId(socio, plan);
    }
    public static SocioPlanId from(SocioEntity socio, PlanEntity plan) {
        return new SocioPlanId(socio.getId(), plan.getId());
    }   
    public static SocioPlanId from(SocioPlanEntity entity) {
        return new SocioPlanId(entity.getSocio().getId(), entity.getPlan().getId());
    }

    public static SocioPlanId from(SocioPlanId id) {
        return new SocioPlanId(id.getSocio(), id.getPlan());
    }       
}
