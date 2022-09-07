/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.prf_bknd.controler;

import com.portfolio.prf_bknd.model.Proyectos;
import com.portfolio.prf_bknd.service.IProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProyectosControler {
@Autowired
    private IProyectosService proyectoServ;
    
    
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
//    #@PreAuthorize("")
    @PostMapping ("/proyectos/new")
    public void agregarProyectos(@RequestBody Proyectos project){
    proyectoServ.crearProyectos(project);
    }
    
    @CrossOrigin
    @GetMapping("/proyectos/ver")
    @ResponseBody
    public List <Proyectos> verProyectos(){
      return proyectoServ.verProyectos();
    }
    
    
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/proyectos/delete/{id}")
    public void borrarProyectos (@PathVariable Long id){
    proyectoServ.borrarProyectos(id);
    }
    
    @CrossOrigin
    @GetMapping("/proyectos/buscar/{id}")
    public Proyectos buscarProyectos(@PathVariable Long id){
    return proyectoServ.buscarProyectos(id);
    }
}    
