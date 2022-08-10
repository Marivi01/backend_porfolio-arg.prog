/*
 
 */
package com.portfolio.prf_bknd.repository;

import com.portfolio.prf_bknd.model.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface personaRepository extends JpaRepository <persona, Long>{
    
}
