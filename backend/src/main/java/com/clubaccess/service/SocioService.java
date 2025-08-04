package com.clubaccess.service;

import com.clubaccess.api.dto.SocioDto;
import com.clubaccess.persistance.entity.SocioEntity;
import com.clubaccess.persistance.repository.SocioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.clubaccess.api.dto.SocioResponseDto;

import com.clubaccess.service.SocioServiceInterface;
@Service
public class SocioService implements SocioServiceInterface{

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    @Override
    public SocioResponseDto createSocio(SocioDto dto) {
        SocioEntity entity = new SocioEntity();
        entity.setNombre(dto.getNombre());
        entity.setEmail(dto.getEmail());

        SocioEntity saved = socioRepository.save(entity);

        return toDto(saved);
    }

    @Override
    public SocioResponseDto getSocio(Long id) {
        return socioRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));
    }

    @Override
    public SocioResponseDto updateSocio(Long id, SocioDto dto) {
        SocioEntity entity = socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        entity.setNombre(dto.getNombre());
        entity.setEmail(dto.getEmail());

        SocioEntity updated = socioRepository.save(entity);
        return toDto(updated);
    }

    @Override
    public void deleteSocio(Long id) {
        socioRepository.deleteById(id);
    }

    @Override
    public List<SocioResponseDto> listSocios() {
        return socioRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private SocioResponseDto toDto(SocioEntity entity) {
        SocioResponseDto dto = new SocioResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre()); 
        dto.setEmail(entity.getEmail());   
        return dto;
    }

}
