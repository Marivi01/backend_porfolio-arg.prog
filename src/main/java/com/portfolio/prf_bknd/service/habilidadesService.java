
package com.portfolio.prf_bknd.service;


import com.portfolio.prf_bknd.model.Habilidad;
import com.portfolio.prf_bknd.repository.habilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class habilidadesService implements IHabilidadesService{
    
    @Autowired
    public habilidadesRepository habilidadesRepo;

    @Override
    public List<Habilidad> verHabilidad() {
        return habilidadesRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad Habil) {
       habilidadesRepo.save(Habil);
    }

    @Override
    public void borrarHabilidad(Long id) {
      habilidadesRepo .deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
      return habilidadesRepo.findById(id)
                .orElse(null); 
    }
   
   

}
