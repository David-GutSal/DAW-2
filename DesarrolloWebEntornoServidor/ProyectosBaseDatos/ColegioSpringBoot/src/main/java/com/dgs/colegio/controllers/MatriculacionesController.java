package com.dgs.colegio.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.colegio.dao.interfaces.IDesplegablesDAO;
import com.dgs.colegio.dao.interfaces.IMatriculacionesDAO;
import com.dgs.colegio.dtos.DesplegableDTO;
import com.dgs.colegio.dtos.MatriculacionDTO;

@Controller
@RequestMapping("/matriculaciones")
public class MatriculacionesController {
	
	@Autowired
	IDesplegablesDAO desplegables;
	@Autowired
	IMatriculacionesDAO matriculacionesService;
	
	@GetMapping("/listadoMatriculaciones")
	public String formularioListadoNota() {
		return "matriculaciones/listadoMatriculaciones";
	}
	
	@PostMapping("/listadoMatriculaciones")
	public String listadoAlumnos(
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo", required = false) Integer activo,  ModelMap model) {
		
		Integer act = activo != null ? 1 : 0;
		if(fecha == null || fecha.trim().isEmpty()) {
			fecha = "0001-01-01";
		}
		
		ArrayList<MatriculacionDTO> listaNotas = matriculacionesService.obtenerMatriculacionesPorFiltros(nombreAsignatura, nombreAlumno, fecha, act);
		model.addAttribute("lista", listaNotas);
		return "matriculaciones/listadoMatriculaciones";
	}
	
	@GetMapping("/insertarMatriculaciones")
	public void insertarNota(ModelMap model) {
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
	}
	
	@PostMapping("/insertarMatriculaciones")
	public void insertarNota(
			@RequestParam(value = "alumno", required = false) Integer alumno,
			@RequestParam(value = "asignatura", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) String tasa,
			@RequestParam(value = "fecha", required = false) String fecha,  ModelMap model) {
		
		if (fecha == null || fecha.trim().isEmpty()) {
            fecha = LocalDate.now().toString();
        }
		
		Integer resultado = notasService.insertarNota(alumno, asignatura, nota, fecha);
		
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		model.addAttribute("resultado", resultado);
	}
}
