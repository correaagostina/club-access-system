package com.clubaccess.api.controller;

import com.clubaccess.api.dto.SocioDto;
import com.clubaccess.persistance.entity.SocioEntity;
import com.clubaccess.service.SocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.clubaccess.api.dto.SocioResponseDto;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @PostMapping
    public ResponseEntity<SocioResponseDto> create(@RequestBody SocioDto dto) {
        return ResponseEntity.ok(socioService.createSocio(dto));
    }

    @GetMapping
    public ResponseEntity<List<SocioResponseDto>> list() {
        return ResponseEntity.ok(socioService.listSocios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(socioService.getSocio(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        socioService.deleteSocio(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioResponseDto> update(@PathVariable Long id, @RequestBody SocioDto socioDto) {
        return ResponseEntity.ok(socioService.updateSocio(id, socioDto));
    }

}
