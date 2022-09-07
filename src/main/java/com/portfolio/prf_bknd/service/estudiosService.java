
package com.portfolio.prf_bknd.service;

import com.portfolio.prf_bknd.model.Estudio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.prf_bknd.repository.estudiosRepository;

@Service
public class estudiosService implements IEstudiosService{
    @Autowired
    public estudiosRepository estudioRepo;
    @Override
    public List<Estudio> verEstudios() {
        return estudioRepo.findAll();
    }

    @Override
    public void crearEstudios(Estudio est) {
        estudioRepo.save(est);
    }

    @Override
    public void borrarEstudios(Long id) {
        estudioRepo.deleteById(id);
    }

    @Override
    public Estudio buscarEstudios(Long id) {
        return estudioRepo.findById(id)
                .orElse(null); 
    }

    
}
