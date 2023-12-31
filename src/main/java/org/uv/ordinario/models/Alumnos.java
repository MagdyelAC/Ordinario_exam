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

@Entity(name = "alumnos")
public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "claveAl")
    private int clave;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name="direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "al")
    private Set<Grupos> grupo;

    public Alumnos() {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Grupos> getGrupo() {
        return grupo;
    }

    public void setGrupo(Set<Grupos> grupo) {
        this.grupo = grupo;
    }
    
    
}
