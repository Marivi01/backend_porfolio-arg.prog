
package com.portfolio.prf_bknd.repository;

import com.portfolio.prf_bknd.model.ExperienciaLab;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface experienciaRepository extends JpaRepository<ExperienciaLab, Integer> {
public Optional<ExperienciaLab> findByNombreExp(String nombreExp);
public boolean existsByNombreExp(String nombreExp);
}
