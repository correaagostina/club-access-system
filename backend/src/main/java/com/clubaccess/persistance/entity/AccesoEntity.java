package com.clubaccess.persistance.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="accesos")
public class AccesoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "socio_id")
    private SocioEntity socio;

    private LocalDateTime timestamp = LocalDateTime.now();

    private boolean validado;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public Boolean getValidado() {
        return validado;
    }
    public void setValidado(Boolean validado) {
        this.validado = validado;
    }
    public SocioEntity getSocio() {
        return socio;
    }
    public void setSocio(SocioEntity socio) {
        this.socio = socio;
    }
    
}
