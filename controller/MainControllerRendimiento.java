package com.fondofamiliar1.fondo.controller;

import com.fondofamiliar1.fondo.models.Ahorro;
import com.fondofamiliar1.fondo.models.Rendimiento;
import com.fondofamiliar1.fondo.repository.RendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fondo/familiar/ada/v1")
public class MainControllerRendimiento {

    @Autowired
    private RendimientoRepository rendimientoRepository;

    @GetMapping(path = "/rendimiento/all")
    public @ResponseBody
    Iterable<Rendimiento> getAllRendimientos(){
        return rendimientoRepository.findAll();
    }
}
