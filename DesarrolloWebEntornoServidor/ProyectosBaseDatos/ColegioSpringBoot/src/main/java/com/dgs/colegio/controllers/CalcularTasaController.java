package com.dgs.colegio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.colegio.service.interfaces.IMatriculacionesService;

@Controller
@RequestMapping("/tasa")
public class CalcularTasaController {

	IMatriculacionesService matriculacionesService;
	
	@GetMapping("/insertarMatriculacion")
	public void formularioListadoNota() {
	}

	@PostMapping("/insertarMatriculacion")
	public String listadoAlumnos(@RequestParam(value = "nombreAsignatura", required = false) Integer asignatura,
			@RequestParam(value = "nombreAlumno", required = false) Integer alumno,
			@RequestParam(value = "fecha", required = false) String tasa, ModelMap model) {
		double tasaFina = matriculacionesService.calcularTasa(asignatura, alumno)
		model.addAttribute("tasa", tasa);
		return "matriculaciones/insertarMatriculacion";
	}

}
