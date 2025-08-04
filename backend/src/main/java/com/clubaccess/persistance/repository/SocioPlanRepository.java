package com.clubaccess.persistance.repository;

import com.clubaccess.persistance.entity.SocioPlanEntity;
import com.clubaccess.persistance.entity.SocioPlanId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;   
import java.util.List;
import java.util.Optional;

@Repository
public interface SocioPlanRepository extends JpaRepository<SocioPlanEntity, SocioPlanId> {
    List<SocioPlanEntity> findBySocioId(Long socioId);
    Optional<SocioPlanEntity> findBySocioIdAndPlanId(Long socioId, Long planId);
}
