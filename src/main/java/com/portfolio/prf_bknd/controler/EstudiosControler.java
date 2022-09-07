
package com.portfolio.prf_bknd.controler;

import com.portfolio.prf_bknd.model.Estudio;
import com.portfolio.prf_bknd.service.IEstudiosService;
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
public class EstudiosControler {
@Autowired
    private IEstudiosService estudiosServ;
    
    
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
//    #@PreAuthorize("")
    @PostMapping ("/new/estudio")
    public void agregarEstudio(@RequestBody Estudio est){
    estudiosServ.crearEstudios(est);
    }
    
    @CrossOrigin
    @GetMapping("/ver/estudios")
    @ResponseBody
    public List <Estudio> verEstudios(){
      return estudiosServ.verEstudios();
    }
    
    
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/estudio/{id}")
    public void borrarEstudios (@PathVariable Long id){
    estudiosServ.borrarEstudios(id);
    }
    
    @CrossOrigin
    @GetMapping("/buscar/estudio/{id}")
    public Estudio buscarEstudios(@PathVariable Long id){
    return estudiosServ.buscarEstudios(id);
    }
}    

