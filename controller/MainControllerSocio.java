package com.fondofamiliar1.fondo.controller;

import com.fondofamiliar1.fondo.models.*;
import com.fondofamiliar1.fondo.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/fondo/familiar/ada/v1")
public class MainControllerSocio {

    @Autowired
    private SocioRepository socioRepository;

    @GetMapping(path = "/socio/all")
    public @ResponseBody
    Iterable<Socio> getAllSocios(){
        return socioRepository.findAll();
    }

    @GetMapping(path = "/socio/{id_socio}")
    public@ResponseBody
    Optional<Socio> getSocioById(@PathVariable("id_socio") int id_s){
        return socioRepository.findById(id_s);
    }

    @PostMapping (path = "/socio/create",
            consumes = "application/json", produces = "application/json")
    public Socio createSocios(@RequestBody Socio newSocio){
        return socioRepository.save(newSocio);
    }

    @PutMapping(path = "/socio/update",
            consumes = "application/json", produces = "application/json")
    public Socio updateSocio(@RequestBody Socio updatedSocio) {
        return socioRepository.save(updatedSocio);
    }

    @DeleteMapping(path ="/socio/delete/{id_socio}")
    public @ResponseBody
    Iterable<Socio> deleteSocioById(@PathVariable("id_socio") int id_s) {
        try {
            socioRepository.deleteById(id_s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return socioRepository.findAll();
        }

    }
    // Consultas Personaliizadas

    // Socio y grupo familiar al que pertenece
    @GetMapping(path = "/socio/grupo_familiar")
    public @ResponseBody
    Iterable<ReporteSocioGrupoFamiliar> getSociosByGrupoFamiliar(){
        return socioRepository.getSociosByGrupoFamiliar();
    }

    // Conteo de intereses generados
    @GetMapping(path = "/socio/conteo/interes")
    public @ResponseBody
    Iterable<ConteoIntereses> getConteoIntereses(){
        return socioRepository.getConteoIntereses();
    }

}
