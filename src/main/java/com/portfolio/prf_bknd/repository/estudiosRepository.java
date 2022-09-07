
package com.portfolio.prf_bknd.repository;

import com.portfolio.prf_bknd.model.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface estudiosRepository extends JpaRepository <Estudio, Long>{
    
}
