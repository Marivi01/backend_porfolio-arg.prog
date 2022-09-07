
package com.portfolio.prf_bknd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreProj;
    private String urlProj;

    public Proyectos() {
    }

    public Proyectos(Long id, String nombreProj, String urlProj) {
        this.id = id;
        this.nombreProj = nombreProj;
        this.urlProj = urlProj;
    }

    public Proyectos(String nombreProj, String urlProj) {
        this.nombreProj = nombreProj;
        this.urlProj = urlProj;
    }
   
   
    
}
