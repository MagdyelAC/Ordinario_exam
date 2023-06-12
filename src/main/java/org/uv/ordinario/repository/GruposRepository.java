/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ordinario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.uv.ordinario.models.Grupos;

public interface GruposRepository extends JpaRepository<Grupos, String>{
    @Query(value = "select * from grupos where claveAl=:id",nativeQuery = true)
    List<Grupos> getAluByGrupId(@Param("id") Integer id);
    @Query(value = "select * from grupos where claveMat=:id",nativeQuery = true)
    List<Grupos> getMatByGrupId(@Param("id") Integer id);
}
