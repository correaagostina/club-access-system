package com.clubaccess.service;

import com.clubaccess.api.dto.SocioDto;
import com.clubaccess.api.dto.SocioResponseDto;

import java.util.List;

public interface SocioServiceInterface {
    SocioResponseDto createSocio(SocioDto dto);
    SocioResponseDto getSocio(Long id);
    SocioResponseDto updateSocio(Long id, SocioDto dto);
    void deleteSocio(Long id);
    List<SocioResponseDto> listSocios();
}
