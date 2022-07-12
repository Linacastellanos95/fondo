package com.fondofamiliar1.fondo.controller;

import com.fondofamiliar1.fondo.models.GrupoFamiliar;
import com.fondofamiliar1.fondo.repository.GrupoFamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fondo/familiar/ada/v1")
public class MainControllerGrupoFamiliar {

    @Autowired
    private GrupoFamiliarRepository grupoFamiliarRepository;

    // Endpoints de "Grupo Familiar" GET, POST, PUT, DELETE
    @GetMapping(path = "/grupo_familiar/all")
    public @ResponseBody
    Iterable<GrupoFamiliar> getAllGrupoFamiliar(){
        return grupoFamiliarRepository.findAll();
    }

    @GetMapping(path = "/grupo_familiar/{id_grupo_familiar}")
    public@ResponseBody
    Optional<GrupoFamiliar> getGrupoFamiliarById(@PathVariable("id_grupo_familiar") int id_gf){
        return grupoFamiliarRepository.findById(id_gf);
    }


    @PostMapping (path = "/grupo_familiar/create",
            consumes = "application/json", produces = "application/json")
    public GrupoFamiliar createGrupoFamiliar(@RequestBody GrupoFamiliar newGrupoFamiliar){
        return grupoFamiliarRepository.save(newGrupoFamiliar);
    }

    @PutMapping(path = "/grupo_familiar/update",
            consumes = "application/json", produces = "application/json")
    public GrupoFamiliar updateGrupoFamiliar (@RequestBody GrupoFamiliar updatedGrupoFamiliar) {
        return grupoFamiliarRepository.save(updatedGrupoFamiliar);
    }

    @DeleteMapping(path ="/grupo_familiar/delete/{id_grupo_familiar}")
    public @ResponseBody
    Iterable<GrupoFamiliar> deleteGrupoFamiliarById(@PathVariable("id_grupo_familiar") int id_gf) {
        try {
            grupoFamiliarRepository.deleteById(id_gf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return grupoFamiliarRepository.findAll();
        }

    }

    // Consultas personalizadas

    // Buscar grupo familiar por nombre
    @GetMapping(path = "/grupo_familiar/name/{grupo_familiar}")
    public@ResponseBody
    List<GrupoFamiliar> getGrupoFamiliarByName(@PathVariable("grupo_familiar") String name){
        return grupoFamiliarRepository.getGrupoFamiliarByName(name);
    }
}
