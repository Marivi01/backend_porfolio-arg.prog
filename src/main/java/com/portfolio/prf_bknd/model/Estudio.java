
package com.portfolio.prf_bknd.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity

public class Estudio {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String institucion;
    private String titulo;

    public Estudio() {
    }

    public Estudio(Long id, String institucion, String titulo) {
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
    }

    public Estudio(String institucion, String titulo) {
        this.institucion = institucion;
        this.titulo = titulo;
    }
   
   
    
}
