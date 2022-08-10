
package com.portfolio.prf_bknd.security.Service;

import com.portfolio.prf_bknd.security.Entity.Rol;
import com.portfolio.prf_bknd.security.Enum.RolNombre;
import com.portfolio.prf_bknd.security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
 @Autowired
 iRolRepository irolRepository;
 
 public Optional<Rol>getByRolNombre(RolNombre rolNombre){
     return irolRepository.findByRolNombre(rolNombre);
 }
 public void save (Rol rol){
     irolRepository.save(rol);
 }

}
