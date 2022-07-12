package com.fondofamiliar1.fondo.controller;

import com.fondofamiliar1.fondo.models.Ahorro;
import com.fondofamiliar1.fondo.models.GrupoFamiliar;
import com.fondofamiliar1.fondo.repository.AhorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fondo/familiar/ada/v1")
public class MainControllerAhorro {

    @Autowired
    private AhorroRepository ahorroRepository;


    @GetMapping(path = "/ahorro/all")
    public @ResponseBody
    Iterable<Ahorro> getAllAhorros(){
        return ahorroRepository.findAll();
    }

    @GetMapping(path = "/ahorro/{id_ahorro}")
    public@ResponseBody
    Optional<Ahorro> getAhorroById(@PathVariable("id_ahorro") int id){
        return ahorroRepository.findById(id);
    }

    @PostMapping (path = "/ahorro/create",
            consumes = "application/json", produces = "application/json")
    public Ahorro createAhorro(@RequestBody Ahorro newAhorro){
        return ahorroRepository.save(newAhorro);
    }

    @PutMapping(path = "/ahorro/update",
            consumes = "application/json", produces = "application/json")
    public Ahorro updateAhorro (@RequestBody Ahorro updatedAhorro) {
        return ahorroRepository.save(updatedAhorro);
    }

    @DeleteMapping(path ="/ahorro/delete/{id_ahorro}")
    public @ResponseBody
    Iterable<Ahorro> deleteAhorroById(@PathVariable("id_ahorro") int id) {
        try {
            ahorroRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return ahorroRepository.findAll();
        }

    }
}
