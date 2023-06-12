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
import org.uv.ordinario.dtos.MateriaDTO;
import org.uv.ordinario.models.Materias;
import org.uv.ordinario.repository.MateriasRepository;

@RestController
@RequestMapping("/api")
public class MateriasController {
    @Autowired
    private MateriasRepository materiaRep;
    
    @GetMapping("/materia/{id}")
    public MateriaDTO findById(@PathVariable("id") int id){
        Optional<Materias> res= materiaRep.findById(id);
        MateriaDTO matDto= null;
        
        if(res.isPresent()){
            matDto= new MateriaDTO();
            matDto.setClave(res.get().getClave());
            matDto.setNombre(res.get().getNombre());
            matDto.setCreditos(res.get().getCreditos());
        }
        
        return matDto;
    }
    
    @GetMapping("/materia")
    public List<MateriaDTO> findAll(){
        List<MateriaDTO> matDtoLis= new ArrayList<>();
        
        List<Materias> matLis= materiaRep.findAll();
        MateriaDTO matDto;
        for (Materias mat : matLis) {
            matDto = new MateriaDTO();
            matDto.setClave(mat.getClave());
            matDto.setNombre(mat.getNombre());
            matDto.setCreditos(mat.getCreditos());
            matDtoLis.add(matDto);
        }
        
        return matDtoLis;
    }
    
    @PostMapping("/materia")
    public MateriaDTO create(@RequestBody Materias materia){
        Materias mat= new Materias();
        mat.setClave(materia.getClave());
        mat.setNombre(materia.getNombre());
        mat.setCreditos(materia.getCreditos());
        Materias matNew= materiaRep.save(mat);
        
        MateriaDTO matDto =new MateriaDTO();
        matDto.setClave(matNew.getClave());
        matDto.setNombre(matNew.getNombre());
        matDto.setCreditos(matNew.getCreditos());
        
        return matDto;
    }
    
    @DeleteMapping("/materia/{id}")
    public String delete(@PathVariable int id){
        materiaRep.deleteById(id);
        return "Se ha borrado el registro";
    }
    
    @PutMapping("/materia")
    public MateriaDTO update(@RequestBody Materias materia){
        Optional<Materias> opt=materiaRep.findById(materia.getClave());
        MateriaDTO matDto=null;
        if(opt.isPresent()){
            matDto= new MateriaDTO();
            Materias matNew=materiaRep.save(materia);
            matDto.setClave(matNew.getClave());
            matDto.setNombre(matNew.getNombre());
            matDto.setCreditos(matNew.getCreditos());
            return matDto;
        }
        else{
            Logger.getLogger(AlumnosController.class.getName()).log(Logger.Level.INFO,"No se encontro el registro con el id {0}", new Object[]{materia.getClave()});
            return matDto;
        }
    }
}
