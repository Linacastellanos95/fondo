package com.fondofamiliar1.fondo.repository;

import com.fondofamiliar1.fondo.models.ConteoIntereses;
import com.fondofamiliar1.fondo.models.ReporteSocioGrupoFamiliar;
import com.fondofamiliar1.fondo.models.Socio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SocioRepository extends CrudRepository<Socio, Integer> {

    // Socio y grupo familiar al que pertenece
    @Query(value = "select concat (s.nombre,\" \", s.apellido) as nombreCompleto, gf.nombre as grupoFamiliar " +
            "from socio as s inner join grupo_familiar as gf on s.grupo_familiar_id = gf.id;" , nativeQuery = true)
    Iterable<ReporteSocioGrupoFamiliar> getSociosByGrupoFamiliar();

    // Conteo de intereses generados

    @Query(value = "select p.interes as interes, count(p.id) as conteo from socio as s " +
            "left join prestamo as p on p.socio_id = s.id group by p.interes", nativeQuery = true)
    Iterable<ConteoIntereses> getConteoIntereses();
}
