package com.portfolio.prf_bknd.controler;

import com.portfolio.prf_bknd.model.Habilidad;
import com.portfolio.prf_bknd.service.IHabilidadesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HabilidadesControler {
    

@Autowired
    private IHabilidadesService habilidadesServ;
    
    
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping ("/new/habilidad")
    public void agregarHabilidad(@RequestBody Habilidad habil){
    habilidadesServ.crearHabilidad(habil);
    }
    
    @CrossOrigin
    @GetMapping("/ver/habilidad")
    @ResponseBody
    public List <Habilidad> verHabilidad(){
      return habilidadesServ.verHabilidad();
    }
    
    @CrossOrigin
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/habilidad/{id}")
    public void borrarHabilidad (@PathVariable Long id){
    habilidadesServ.borrarHabilidad(id);
    }
    
    @CrossOrigin
    @GetMapping("/buscar/habilidad/{id}")
    public Habilidad buscarHabilidad(@PathVariable Long id){
    return habilidadesServ.buscarHabilidad(id);
    }
}    