
package com.portfolio.prf_bknd.service;

import com.portfolio.prf_bknd.model.Estudio;
import com.portfolio.prf_bknd.model.Habilidad;
import java.util.List;


public interface IHabilidadesService {
     public List <Habilidad> verHabilidad();
   
   public void crearHabilidad (Habilidad Habil);
   
   public void borrarHabilidad (Long id);
   
   public Habilidad buscarHabilidad (Long id);
}
