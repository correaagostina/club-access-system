package com.clubaccess.api.dto;

public class AccesoResponseDto {
    private boolean permitido;
    private String mensaje;

    public AccesoResponseDto(boolean permitido, String mensaje) {
        this.permitido = permitido;
        this.mensaje = mensaje;
    }

    public boolean isPermitido() {
        return permitido;
    }

    public void setPermitido(boolean permitido) {
        this.permitido = permitido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
