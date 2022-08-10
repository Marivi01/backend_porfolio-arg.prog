
package com.portfolio.prf_bknd.security.Repository;

import com.portfolio.prf_bknd.security.Entity.Rol;
import com.portfolio.prf_bknd.security.Enum.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
