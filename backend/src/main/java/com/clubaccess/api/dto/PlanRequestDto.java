package com.clubaccess.api.dto;

import java.math.BigDecimal;   
import java.time.LocalDate;        

public class PlanRequestDto {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer duracionDias;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public Integer getDuracionDias() {
        return duracionDias;
    }
    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }

    
}
