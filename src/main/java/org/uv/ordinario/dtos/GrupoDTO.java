/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ordinario.dtos;

public class GrupoDTO {
    private int id;
    private String nombreGrupo;
    private int clave_al;
    private int claev_mat;

    public GrupoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getClave_al() {
        return clave_al;
    }

    public void setClave_al(int clave_al) {
        this.clave_al = clave_al;
    }

    public int getClaev_mat() {
        return claev_mat;
    }

    public void setClaev_mat(int claev_mat) {
        this.claev_mat = claev_mat;
    }
    
    
}
