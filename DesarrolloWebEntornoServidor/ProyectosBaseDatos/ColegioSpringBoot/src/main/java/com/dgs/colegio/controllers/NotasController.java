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
	public void insertarNota(
			@RequestParam(value = "alumno", required = false) Integer alumno,
			@RequestParam(value = "asignatura", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) String nota,
			@RequestParam(value = "fecha", required = false) String fecha,  ModelMap model) {
		
		if (fecha == null || fecha.trim().isEmpty()) {
            fecha = LocalDate.now().toString();
        }
		
		Integer resultado = notasService.insertarNota(alumno, asignatura, nota, fecha);
		
		model.addAttribute("resultado", resultado);
	}
	
	@GetMapping("/listadoNotas")
	public String formularioListadoNota() {
		return "notas/listadoNotas";
	}
	
	@PostMapping("/listadoNotas")
	public String listadoAlumnos(
			@RequestParam(value = "idAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "asignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "nota", required = false) String nota,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo", required = false) Integer activo,  ModelMap model) {
		
		Integer act = activo != null ? 1 : 0;
		
		ArrayList<NotaDTO> listaNotas;
		if (fecha == null || fecha.trim().isEmpty()) {
			listaNotas = notasService.obtenerNotasPorFiltrosSinFecha(idAlumno, nombreAlumno, nombreAsignatura,nota, act);
        } else {
        	listaNotas = notasService.obtenerNotasPorFiltros(idAlumno, nombreAlumno, nombreAsignatura, nota, fecha, act);
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
			@RequestParam(value = "nombreAlumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		ArrayList<NotaDTO> listaNotas;
		if (fecha == null || fecha.trim().isEmpty()) {
			listaNotas = notasService.obtenerNotasPorFiltrosSinFecha(null, alumno, asignatura,"", 1);
        } else {
        	listaNotas = notasService.obtenerNotasPorFiltros(null, alumno, asignatura, fecha, "" ,1);
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
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "alumno", required = false) Integer alumno,
			@RequestParam(value = "asignatura", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) Integer nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		Integer resultado = notasService.actualizarNota(id, alumno, asignatura, nota, fecha);
		

		model.addAttribute("resultado", resultado);

		return "notas/actualizarNotas";
	}

	@GetMapping(value = "/formularioBorrarNotas")
	public String getFormularioEliminarNotas() {
		return "notas/borrarNotas";
	}

	@PostMapping(value = "/formularioBorrarNotas")
	public String formularioEliminarNotas(
			@RequestParam(value = "id", required = false) Integer idAlumno,
			@RequestParam(value = "nombreAlumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) String nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {

		ArrayList<NotaDTO> listaNotas;
		if (fecha == null || fecha.trim().isEmpty()) {
        	listaNotas = notasService.obtenerNotasPorFiltrosSinFecha(null, alumno, asignatura,"", 1);
        } else {
			listaNotas = notasService.obtenerNotasPorFiltros(null, alumno, asignatura, "",fecha, 1);
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
			@RequestParam("id") Integer id, ModelMap model) {
		Integer resultado = notasService.borrarNota(id);
		model.addAttribute("resultado", resultado);
		return "notas/borrarNotas";
	}
}
