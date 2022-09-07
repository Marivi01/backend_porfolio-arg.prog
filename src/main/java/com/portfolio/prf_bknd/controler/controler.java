/*
 * Click 
 */
package com.portfolio.prf_bknd.controler;

import com.portfolio.prf_bknd.model.persona;
import com.portfolio.prf_bknd.service.IPersonaService;
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
//
//import com.portfolio.prf_bknd.security.DTO.JwtDto;
//import com.portfolio.prf_bknd.security.DTO.LoginUsuario;
//import com.portfolio.prf_bknd.security.DTO.NuevoUsuario;
//import com.portfolio.prf_bknd.security.Entity.Rol;
//import com.portfolio.prf_bknd.security.Entity.Usuario;
//import com.portfolio.prf_bknd.security.Enum.RolNombre;
//import com.portfolio.prf_bknd.security.Service.RolService;
//import com.portfolio.prf_bknd.security.Service.UsuarioService;
//import com.portfolio.prf_bknd.security.jwt.JwtProviders;





@RestController
@CrossOrigin
public class controler {
    @Autowired
    private IPersonaService persoServ;
    
    
   //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/persona")
    public void agregarPersona(@RequestBody persona pers){
    persoServ.crearPersona(pers);
    }
    
    @CrossOrigin
    @GetMapping("/ver/personas")
    @ResponseBody
    public List <persona> verPersonas(){
      return persoServ.verPersonas();
    }
    
    @CrossOrigin
   // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
    persoServ.borrarPersona(id);
    }
    
    @CrossOrigin
    @GetMapping("/buscar/persona/{id}")
    public persona buscarPersona(@PathVariable Long id){
    return persoServ.buscarPersona(id);
    }
}
//
