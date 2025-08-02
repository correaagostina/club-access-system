package com.clubaccess.persistance.repository;
import java.util.List;
import java.util.Optional;

import com.clubaccess.persistance.entity.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clubaccess.model.Socio;

@Repository
public interface SocioRepository extends JpaRepository<SocioEntity, Long>{

    List<SocioEntity> findByEmail(String email);
    Optional<SocioEntity> findById(Long id);
    
}
