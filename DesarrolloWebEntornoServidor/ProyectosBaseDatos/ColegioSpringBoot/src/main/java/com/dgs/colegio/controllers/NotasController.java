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
import com.dgs.colegio.dtos.DesplegableDTO;
import com.dgs.colegio.dtos.NotaDTO;
import com.dgs.colegio.service.interfaces.INotasService;

@Controller
@RequestMapping("/notas")
public class NotasController {
	@Autowired
	INotasService notasService;
	@Autowired
	IDesplegablesDAO desplegables;
	
	@GetMapping("/insertarNota")
	public void insertarNota(ModelMap model) {
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
	}
	
	@PostMapping("/insertarNota")
	public void insertarAsignatura(
			@RequestParam(value = "alumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) String nota,
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
	
	@GetMapping("/listadoNota")
	public String formularioListadoNota() {
		return "notas/listadoNotas";
	}
	
	@PostMapping("/listadoNota")
	public String listadoAlumnos(
			@RequestParam(value = "alumno", required = false) String idAlumno,
			@RequestParam(value = "alumno", required = false) String nombreAlumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) String nota,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo", required = false) Integer activo,  ModelMap model) {
		
		Integer act = activo != null ? 1 : 0;
		
		ArrayList<NotaDTO> listaNotas;
		if (fecha == null || fecha.trim().isEmpty()) {
			listaNotas = notasService.obtenerNotasPorFiltros(idAlumno, nombreAlumno, asignatura, nota, fecha, act);
        } else {
        	listaNotas = notasService.obtenerNotasPorFiltrosSinFecha(idAlumno, nombreAlumno, asignatura,nota, act);
        }
		
		model.addAttribute("lista", listaNotas);
		return "notas/listadoNotas";
	}
	
	@GetMapping(value = "/formularioActualizarNotas")
	public String formularioModificarNotas(ModelMap model) {
		return "notas/actualizarNotas";
	}
	
	@PostMapping(value = "/formularioActualizarNotas")
	public String formularioModificarNotas(
			@RequestParam(value = "alumno", required = false) String idAlumno,
			@RequestParam(value = "alumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) String nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		ArrayList<NotaDTO> listaNotas;
		if (fecha == null || fecha.trim().isEmpty()) {
			listaNotas = notasService.obtenerNotasPorFiltros("", alumno, asignatura, fecha, nota ,1);
        } else {
        	listaNotas = notasService.obtenerNotasPorFiltrosSinFecha("", alumno, asignatura,"", 1);
        }
		
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		model.addAttribute("lista", listaNotas);
		return "notas/actualizarNotas";
	}
	
	@PostMapping(value = "/actualizarNota")
	public String modificarNotas(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "alumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) String nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		ArrayList<NotaDTO> listaNotas;
		if (fecha == null || fecha.trim().isEmpty()) {
			listaNotas = notasService.obtenerNotasPorFiltros(id, alumno, asignatura, nota, fecha, 1);
        } else {
        	listaNotas = notasService.obtenerNotasPorFiltrosSinFecha(id, alumno, asignatura, nota, 1);
        }
		
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		model.addAttribute("lista", listaNotas);
		return "notas/actualizarNotas";
	}

	@GetMapping(value = "/formularioBorrarNotas")
	public String getFormularioEliminarNotas() {
		return "notas/borrarNotas";
	}

	@PostMapping(value = "/formularioBorrarNotas")
	public String formularioEliminarNotas(
			@RequestParam(value = "alumno", required = false) String idAlumno,
			@RequestParam(value = "alumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) String nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {

		ArrayList<NotaDTO> listaNotas;
		if (fecha == null || fecha.trim().isEmpty()) {
			listaNotas = notasService.obtenerNotasPorFiltros(idAlumno, alumno, asignatura, nota,fecha, 1);
        } else {
        	listaNotas = notasService.obtenerNotasPorFiltrosSinFecha(idAlumno, alumno, asignatura,nota, 1);
        }
		
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		model.addAttribute("lista", listaNotas);
		return "notas/borrarNotas";
	}

	@PostMapping(value = "/borrarNota")
	public String eliminarNotas(
			@RequestParam("id") String id, ModelMap model) {
		Integer resultado = notasService.borrarNota(id);
		model.addAttribute("resultado", resultado);
		return "notas/borrarNotas";
	}
}
