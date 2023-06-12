/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ordinario.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "grupos")
public class Grupos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    
    @Column(name="nombre_grupo")
    private String nombreGrupo;
    
    @ManyToOne
    @JoinColumn(name = "claveAl")
    private Alumnos al;
    
    @ManyToOne
    @JoinColumn(name = "claveMat")
    private Materias mat;

    public Grupos() {
        al= new Alumnos();
        mat=new Materias();
    }
        
    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Alumnos getAl() {
        return al;
    }

    public void setAl(Alumnos al) {
        this.al = al;
    }

    public Materias getMat() {
        return mat;
    }

    public void setMat(Materias mat) {
        this.mat = mat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
