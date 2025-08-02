package com.clubaccess.service;

import com.clubaccess.api.dto.AccesoDto;
import com.clubaccess.persistance.entity.AccesoEntity;
import com.clubaccess.persistance.entity.SocioEntity;
import com.clubaccess.persistance.repository.AccesoRepository;
import com.clubaccess.persistance.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccesoService {

    private final AccesoRepository accesoRepository;
    private final SocioRepository socioRepository;

    public AccesoService(AccesoRepository accesoRepository, SocioRepository socioRepository) {
        this.accesoRepository = accesoRepository;
        this.socioRepository = socioRepository;
    }

    public AccesoEntity registrarAcceso(AccesoDto dto) {
        SocioEntity socio = socioRepository.findAll().stream()
                .filter(s -> s.getQrCode().equals(dto.getQrCode()) && s.isEstado())
                .findFirst()
                .orElse(null);

        AccesoEntity acceso = new AccesoEntity();
        acceso.setTimestamp(LocalDateTime.now());
        acceso.setValidado(socio != null);
        acceso.setSocio(socio); // puede ser null si no se encontró

        return accesoRepository.save(acceso);
    }

    public List<AccesoEntity> listarAccesos() {
        return accesoRepository.findAll();
    }

    public List<AccesoEntity> accesosPorSocio(Long socioId) {
        return accesoRepository.findBySocioId(socioId);
    }
}
