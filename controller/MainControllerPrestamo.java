package com.fondofamiliar1.fondo.controller;

import com.fondofamiliar1.fondo.models.*;
import com.fondofamiliar1.fondo.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fondo/familiar/ada/v1")
public class MainControllerPrestamo {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping(path = "/prestamo/all")
    public @ResponseBody
    Iterable<Prestamo> getAllPrestamos(){
        return prestamoRepository.findAll();
    }

    @GetMapping(path = "/prestamo/{id_prestamo}")
    public@ResponseBody
    Optional<Prestamo> getPrestamoById(@PathVariable("id_prestamo") int id_p){
        return prestamoRepository.findById(id_p);
    }

    @PostMapping (path = "/prestamo/create",
            consumes = "application/json", produces = "application/json")
    public Prestamo createPrestamos(@RequestBody Prestamo newPrestamo){
        return prestamoRepository.save(newPrestamo);
    }

    @PutMapping(path = "/prestamo/update",
            consumes = "application/json", produces = "application/json")
    public Prestamo updatePrestamo(@RequestBody Prestamo updatedPrestamo) {
        return prestamoRepository.save(updatedPrestamo);
    }

    @DeleteMapping(path ="/prestamo/delete/{id_prestamo}")
    public @ResponseBody
    Iterable<Prestamo> deletePrestamoById(@PathVariable("id_prestamo") int id_p) {
        try {
            prestamoRepository.deleteById(id_p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return prestamoRepository.findAll();
        }

    }

    // Consultas personalizadas

    @GetMapping(path = "/prestamo/conteo/mes")
    public @ResponseBody
    List<ConteoPrestamoMes> getConteoPrestamosByMonth(){
        return prestamoRepository.getConteoPrestamosByMonth();
    }

    @GetMapping(path = "/prestamo/conteo/{prestamo}")
    public@ResponseBody
    List<ConteoPrestamoMes> getConteoPrestamosByName(@PathVariable("prestamo") int nombre){
        return prestamoRepository.getConteoPrestamosByName(nombre);
    }
}
