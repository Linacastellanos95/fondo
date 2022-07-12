package com.fondofamiliar1.fondo.repository;

import com.fondofamiliar1.fondo.models.GrupoFamiliar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

public interface GrupoFamiliarRepository extends CrudRepository<GrupoFamiliar, Integer> {

    @Query(value = "select * from grupo_familiar where nombre like %:name%", nativeQuery = true)
    List<GrupoFamiliar> getGrupoFamiliarByName (@Param("name") String nombre);


}
