/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ordinario.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.ordinario.dtos.AlumnosDTO;
import org.uv.ordinario.models.Alumnos;
import org.uv.ordinario.repository.AlumnosRepository;

@RestController
@RequestMapping("/api")
public class AlumnosController {
    @Autowired
    private AlumnosRepository alumnoRep;
    
    @GetMapping("/alumno/{id}")
    public AlumnosDTO findById(@PathVariable("id") int id){
        Optional<Alumnos> res= alumnoRep.findById(id);
        AlumnosDTO alDto= null;
        
        if(res.isPresent()){
            alDto= new AlumnosDTO();
            alDto.setClave(res.get().getClave());
            alDto.setNombre(res.get().getNombre());
            alDto.setDireccion(res.get().getDireccion());
            alDto.setTelefono(res.get().getTelefono());
        }
        
        return alDto;
    }
    
    @GetMapping("/alumno")
    public List<AlumnosDTO> findAll(){
        List<AlumnosDTO> alDtoLis= new ArrayList<>();
        
        List<Alumnos> alLis= alumnoRep.findAll();
        AlumnosDTO alDto;
        for (Alumnos re : alLis) {
            alDto = new AlumnosDTO();
            alDto.setClave(re.getClave());
            alDto.setNombre(re.getNombre());
            alDto.setDireccion(re.getDireccion());
            alDto.setTelefono(re.getTelefono());
            alDtoLis.add(alDto);
        }
        
        return alDtoLis;
    }
    
    @PostMapping("/alumno")
    public AlumnosDTO create(@RequestBody Alumnos alumno){
        Alumnos alm= new Alumnos();
        alm.setClave(alumno.getClave());
        alm.setNombre(alumno.getNombre());
        alm.setDireccion(alumno.getDireccion());
        alm.setTelefono(alumno.getTelefono());
        Alumnos alNew= alumnoRep.save(alm);
        
        AlumnosDTO alDto= new AlumnosDTO();
        alDto.setClave(alNew.getClave());
        alDto.setNombre(alNew.getNombre());
        alDto.setDireccion(alNew.getDireccion());
        alDto.setTelefono(alNew.getTelefono());
        
        return alDto;
    }
    
    @DeleteMapping("/alumno/{id}")
    public String delete(@PathVariable int id){
        alumnoRep.deleteById(id);
        return "Se ha borrado el registro";
    }
    
    @PutMapping("/alumno")
    public AlumnosDTO update(@RequestBody Alumnos alumno){
        Optional<Alumnos> opt=alumnoRep.findById(alumno.getClave());
        AlumnosDTO alDto=null;
        if(opt.isPresent()){
            alDto= new AlumnosDTO();
            Alumnos alNew=alumnoRep.save(alumno);
            alDto.setClave(alNew.getClave());
            alDto.setNombre(alNew.getNombre());
            alDto.setDireccion(alNew.getDireccion());
            alDto.setTelefono(alNew.getTelefono());
            return alDto;
        }
        else{
            Logger.getLogger(AlumnosController.class.getName()).log(Logger.Level.INFO,"No se encontro el registro con el id {0}", new Object[]{alumno.getClave()});
            return alDto;
        }
    }
}
