
package com.portfolio.prf_bknd.repository;


import com.portfolio.prf_bknd.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface proyectosRepository extends JpaRepository <Proyectos, Long>{
}
    

