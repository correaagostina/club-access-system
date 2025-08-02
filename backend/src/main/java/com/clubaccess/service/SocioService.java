package com.clubaccess.service;

import com.clubaccess.api.dto.SocioDto;
import com.clubaccess.persistance.entity.SocioEntity;
import com.clubaccess.persistance.repository.SocioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public SocioEntity crearSocio(SocioDto dto) {
        SocioEntity socio = new SocioEntity();
        socio.setNombre(dto.getNombre());
        socio.setEmail(dto.getEmail());
        socio.setFechaAlta(LocalDate.now());
        socio.setEstado(true);
        socio.setQrCode(generateQrCode(dto.getEmail()));

        return socioRepository.save(socio);
    }

    public List<SocioEntity> listarSocios() {
        return socioRepository.findAll();
    }

    public Optional<SocioEntity> obtenerPorId(Long id) {
        return socioRepository.findById(id);
    }

    public void eliminarSocio(Long id) {
        socioRepository.deleteById(id);
    }

    private String generateQrCode(String base) {
        return "QR-" + base.hashCode();
    }
}
