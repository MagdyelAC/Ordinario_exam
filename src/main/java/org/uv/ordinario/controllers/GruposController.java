/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ordinario.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.ordinario.dtos.AlumnoMateriaDTO;
import org.uv.ordinario.dtos.AlumnosDTO;
import org.uv.ordinario.dtos.GrupoAlumnoDTO;
import org.uv.ordinario.dtos.GrupoDTO;
import org.uv.ordinario.models.Alumnos;
import org.uv.ordinario.models.Grupos;
import org.uv.ordinario.models.Materias;
import org.uv.ordinario.repository.AlumnosRepository;
import org.uv.ordinario.repository.GruposRepository;
import org.uv.ordinario.repository.MateriasRepository;

@RestController
@RequestMapping("/api")
public class GruposController {
    @Autowired
    private GruposRepository grupoRep;
    @Autowired
    private MateriasRepository matRep;
    @Autowired
    private AlumnosRepository alRep;
    
    @GetMapping("/grupo")
    public List<GrupoDTO> findAll(){
        List<Grupos> grupoLis=grupoRep.findAll();
        List<GrupoDTO> grupDtoLis=new ArrayList<>();
        GrupoDTO grupDto;
        for (Grupos grupoLi : grupoLis) {
            grupDto= new GrupoDTO();
            grupDto.setId(grupoLi.getId());
            grupDto.setNombreGrupo(grupoLi.getNombreGrupo());
            grupDto.setClave_al(grupoLi.getAl().getClave());
            grupDto.setClaev_mat(grupoLi.getMat().getClave());
            grupDtoLis.add(grupDto);
        }
        
        return grupDtoLis;
    }
    
    @PostMapping("/grupo")
    public GrupoAlumnoDTO createGrupo(@RequestBody AlumnoMateriaDTO alMat){
        Grupos grupo;
        GrupoAlumnoDTO grupDto= new GrupoAlumnoDTO();
        
        
        
        Optional<Materias> resMat=matRep.findById(alMat.getClaveMat());
        Materias mat;
        
        if(resMat.isPresent()){
            mat= new Materias();
            mat.setClave(resMat.get().getClave());
            mat.setNombre(resMat.get().getNombre());
            mat.setCreditos(resMat.get().getCreditos());
            
            
            Alumnos al;
            grupo= new Grupos();
            
            for (AlumnosDTO alLi : alMat.getAluLis()) {
                grupo = new Grupos();

                grupo.setNombreGrupo(alMat.getNomGrup());
                grupo.setMat(mat);
                Optional<Alumnos> resAl = alRep.findById(alLi.getClave());
                if (resAl.isPresent()) {
                    al = new Alumnos();
                    al.setClave(alLi.getClave());
                    al.setNombre(alLi.getNombre());
                    al.setDireccion(alLi.getDireccion());
                    al.setTelefono(alLi.getTelefono());
                    grupo.setAl(al);
                }
                grupoRep.save(grupo);
            }

            
            grupDto.setNomGrupo(grupo.getNombreGrupo());
            grupDto.setClaveMat(grupo.getMat().getClave());
            grupDto.setNombreMat(grupo.getMat().getNombre());
            grupDto.setAluLis(alMat.getAluLis());

            return grupDto;
        }
        return null;
    }
}
