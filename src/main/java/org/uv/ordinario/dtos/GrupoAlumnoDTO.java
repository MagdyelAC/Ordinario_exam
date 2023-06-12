/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ordinario.dtos;

import java.util.List;

public class GrupoAlumnoDTO {
    private String nomGrupo;
    private int claveMat;
    private String nombreMat;
    private List<AlumnosDTO> aluLis;

    public GrupoAlumnoDTO() {
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    public int getClaveMat() {
        return claveMat;
    }

    public void setClaveMat(int claveMat) {
        this.claveMat = claveMat;
    }

    public List<AlumnosDTO> getAluLis() {
        return aluLis;
    }

    public void setAluLis(List<AlumnosDTO> aluLis) {
        this.aluLis = aluLis;
    }

    public String getNombreMat() {
        return nombreMat;
    }

    public void setNombreMat(String nombreMat) {
        this.nombreMat = nombreMat;
    }
    
    
    
    
}
