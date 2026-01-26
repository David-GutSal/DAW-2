package com.dgs.colegio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgs.colegio.service.interfaces.IMatriculacionesService;

@Controller
@RequestMapping("/tasa")
public class CalcularTasaController {

	@Autowired
    IMatriculacionesService matriculacionesService;
    
    @GetMapping("/insertarMatriculacion")
    public void formularioListadoNota() {
    }

    @PostMapping
    @ResponseBody
    public String calcularTasa(
    		@RequestParam(value = "asignaturas", required = false) Integer asignatura,
    		@RequestParam(value = "alumnos", required = false) Integer alumno,
                               ModelMap model) {
        if (asignatura == null || alumno == null) {
            return "0";
        }
        double tasaFina = matriculacionesService.calcularTasa(asignatura, alumno);
        return String.valueOf(tasaFina);
    }
}