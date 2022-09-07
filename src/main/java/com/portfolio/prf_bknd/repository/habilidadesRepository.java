
package com.portfolio.prf_bknd.repository;

import com.portfolio.prf_bknd.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface habilidadesRepository extends JpaRepository <Habilidad, Long>{
    
}
 
    

