
package com.portfolio.prf_bknd.service;

import com.portfolio.prf_bknd.model.ExperienciaLab;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.prf_bknd.repository.experienciaRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    experienciaRepository experienciaRepo;
    
    public List<ExperienciaLab> list (){
    return experienciaRepo.findAll();
    }
    
    public Optional<ExperienciaLab> getOne(int id){
    return experienciaRepo.findById(id);
    }
    
    public Optional <ExperienciaLab>getByNombreExp(String nombreExp){
    return experienciaRepo.findByNombreExp(nombreExp);
    }

    public void save (ExperienciaLab exper){
    experienciaRepo.save(exper);
    }
    
    public void delete (int id){
    experienciaRepo.deleteById(id);
    }
    
    public boolean existById(int id){
    return experienciaRepo.existsById(id);
    }
    
    public boolean existByNombreExp (String nombreExp){
    return experienciaRepo.existsByNombreExp(nombreExp);
    }
    }
    

