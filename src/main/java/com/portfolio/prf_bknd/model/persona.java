
package com.portfolio.prf_bknd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
public class persona {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String titulo;
    
    public persona(){
    }
    
    public persona(Long id, String nombre, String apellido, String titulo){
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.titulo= titulo;
    
   }

    public persona(String nombre, String apellido, String titulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
    }
    
    
    
}
