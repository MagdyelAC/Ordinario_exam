/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ordinario.dtos;

import java.util.List;

public class AlumnoMateriaDTO {
    private String nomGrup;
    private int claveMat;
    private List<AlumnosDTO> aluLis;

    public AlumnoMateriaDTO() {
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

    public String getNomGrup() {
        return nomGrup;
    }

    public void setNomGrup(String nomGrup) {
        this.nomGrup = nomGrup;
    }
    
    
}
