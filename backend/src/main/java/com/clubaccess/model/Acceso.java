package com.clubaccess.model;

import java.time.LocalDateTime;

public class Acceso {
    private Long id;
    private Long socioId;
    private LocalDateTime timestamp;
    private boolean validado;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSocioId() {
        return socioId;
    }
    public void setSocioId(Long socioId) {
        this.socioId = socioId;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public boolean isValidado() {
        return validado;
    }
    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    
}
