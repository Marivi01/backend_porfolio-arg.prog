
package com.portfolio.prf_bknd.service;


import com.portfolio.prf_bknd.model.Proyectos;
import java.util.List;


public interface IProyectosService {
  public List <Proyectos> verProyectos();
   
  public void crearProyectos (Proyectos project);
   
  public void borrarProyectos (Long id);
   
  public Proyectos buscarProyectos (Long id);
   
      
}
