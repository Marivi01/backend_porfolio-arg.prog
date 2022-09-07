package com.portfolio.prf_bknd.controler;

import com.portfolio.prf_bknd.Dto.DtoExperienciaLab;
import com.portfolio.prf_bknd.model.ExperienciaLab;
import com.portfolio.prf_bknd.security.Controler.Mensaje;
import com.portfolio.prf_bknd.service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exp_lab")
@CrossOrigin
public class ExperienciaLabController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/list")
    public ResponseEntity<List<ExperienciaLab>> list() {
        List<ExperienciaLab> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperienciaLab dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existByNombreExp(dtoexp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }

        ExperienciaLab experienciaLab = new ExperienciaLab(dtoexp.getNombreExp(), dtoexp.getDescripcionExp());
        experienciaService.save(experienciaLab);
        return new ResponseEntity(new Mensaje("Experiencia laboral agregada"), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperienciaLab dtoexp) {

        if (!experienciaService
                .existById(id)) {
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.BAD_REQUEST);
        }

        if (!experienciaService.existByNombreExp(dtoexp.getNombreExp()) && experienciaService.getByNombreExp(dtoexp.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("experiencia ya existente"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoexp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Campo obligarorio"), HttpStatus.BAD_REQUEST);
        }
        ExperienciaLab experienciaLab = experienciaService.getOne(id).get();
        experienciaLab.setNombreExp(dtoexp.getNombreExp());
        experienciaLab.setDescripcionExp((dtoexp.getDescripcionExp()));

        experienciaService.save(experienciaLab);
        return new ResponseEntity(new Mensaje("la experiencia se actualizó correctamenter"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!experienciaService.existById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        experienciaService.delete(id);

        return new ResponseEntity(new Mensaje(" se elimino esta experiencia"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity <ExperienciaLab>getById(@PathVariable("id") int id){
    if (!experienciaService.existById(id))
    return new ResponseEntity(new Mensaje ("inexistente"),
    HttpStatus.NOT_FOUND);
        ExperienciaLab experienciaLab = experienciaService
                .getOne(id)
                .get();
        return new ResponseEntity(experienciaLab,HttpStatus.OK);
        }
}
