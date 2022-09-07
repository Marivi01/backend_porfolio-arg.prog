
package com.portfolio.prf_bknd.service;

import com.portfolio.prf_bknd.model.persona;
import com.portfolio.prf_bknd.repository.personaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 
 */
@Service
public class PersonaService implements IPersonaService {
    @Autowired
    public personaRepository persoRepo;
       @Override
    public List<persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public persona buscarPersona(Long id) {
        return persoRepo.findById(id)
                .orElse(null); 
    }

    
        }
    

