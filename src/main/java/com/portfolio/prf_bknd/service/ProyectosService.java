
package com.portfolio.prf_bknd.service;

import com.portfolio.prf_bknd.model.Estudio;
import com.portfolio.prf_bknd.model.Proyectos;
import com.portfolio.prf_bknd.repository.proyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService{
 @Autowired
    public proyectosRepository proyectoRepo;
    @Override
    public List<Proyectos> verProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public void crearProyectos(Proyectos project) {
        proyectoRepo.save(project);
    }

    @Override
    public void borrarProyectos(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyectos(Long id) {
        return proyectoRepo.findById(id)
                .orElse(null); 
    }

    
}   

