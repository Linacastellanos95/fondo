package com.fondofamiliar1.fondo.repository;

import com.fondofamiliar1.fondo.models.ConteoPrestamoMes;
import com.fondofamiliar1.fondo.models.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestamoRepository extends CrudRepository<Prestamo,Integer> {

    // Lista Número de prestamos por mes
    @Query (value = "select MONTHNAME(STR_TO_DATE(month(fecha_prestamo),'%m'))  as mes, " +
            "count(*) as numPrestamos from prestamo group by month(fecha_prestamo) " +
            "order by month(fecha_prestamo);", nativeQuery = true)
    List<ConteoPrestamoMes> getConteoPrestamosByMonth();

    //  Número de prestamos por mes por ID
    @Query (value = "select MONTHNAME(STR_TO_DATE(month(fecha_prestamo), '%m'))  as mes," +
            " count(*) as numPrestamos from prestamo where month(fecha_prestamo) = 1 " , nativeQuery = true)
    List<ConteoPrestamoMes> getConteoPrestamosByName(@Param("mes") int nombre);
}
