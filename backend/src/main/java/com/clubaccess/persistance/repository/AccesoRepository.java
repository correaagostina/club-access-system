package com.clubaccess.persistance.repository;
import com.clubaccess.persistance.entity.AccesoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clubaccess.model.Acceso;
import java.util.List;

@Repository
public interface AccesoRepository extends JpaRepository<AccesoEntity, Long> {
    List<AccesoEntity> findBySocioId(Long socioId);
}
