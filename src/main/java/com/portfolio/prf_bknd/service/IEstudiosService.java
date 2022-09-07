

 

package com.portfolio.prf_bknd.service;

import com.portfolio.prf_bknd.model.Estudio;
import java.util.List;


public interface IEstudiosService {
     public List <Estudio> verEstudios();
   
   public void crearEstudios (Estudio est);
   
   public void borrarEstudios (Long id);
   
   public Estudio buscarEstudios (Long id);
   
    
}
