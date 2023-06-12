/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ordinario.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "materias")
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="claveMat")
    private int clave;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="creditos")
    private int creditos;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mat")
    private Set<Grupos> grupo;

    public Materias() {
        grupo= new HashSet<>();
    }
        
    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Set<Grupos> getGrupo() {
        return grupo;
    }

    public void setGrupo(Set<Grupos> grupo) {
        this.grupo = grupo;
    }
    
    
}
