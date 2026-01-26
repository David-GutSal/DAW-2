package com.dgs.colegio.controllers;

import java.sql.SQLException;
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
import com.dgs.colegio.dtos.MatriculacionDTO;
import com.dgs.colegio.service.interfaces.IMatriculacionesService;

@Controller
@RequestMapping("/matriculaciones")
public class MatriculacionesController {
	
	@Autowired
	IDesplegablesDAO desplegables;
	@Autowired
	IMatriculacionesService matriculacionesService;
	
	@GetMapping("/listadoMatriculaciones")
	public String formularioListadoMatriculacion() {
		return "matriculaciones/listadoMatriculaciones";
	}
	
	@PostMapping("/listadoMatriculaciones")
	public String listadoMatriculaciones(
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo", required = false) Integer activo,  ModelMap model) {
		
		Integer act = activo != null ? 1 : 0;
		if(fecha == null || fecha.trim().isEmpty()) {
			fecha = "0001-01-01";
		}
		
		ArrayList<MatriculacionDTO> listaMatriculaciones = matriculacionesService.obtenerMatriculacionesPorFiltros(nombreAsignatura, nombreAlumno, fecha, act);
		model.addAttribute("lista", listaMatriculaciones);
		return "matriculaciones/listadoMatriculaciones";
	}
	
	@GetMapping("/insertarMatriculacion")
	public void insertarMatriculacion(ModelMap model) {
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
	}
	
	@PostMapping("/insertarMatriculacion")
	public void insertarMatriculacion(
			@RequestParam(value = "alumno", required = false) Integer alumno,
			@RequestParam(value = "asignatura", required = false) Integer asignatura,
			@RequestParam(value = "tasa", required = false) double tasa,
			@RequestParam(value = "fecha", required = false) String fecha,  ModelMap model) throws SQLException {
		
		if (fecha == null || fecha.trim().isEmpty()) {
            fecha = LocalDate.now().toString();
        }
		
		Integer resultado = matriculacionesService.insertarMatriculacion(alumno, asignatura, tasa, fecha);
		
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		model.addAttribute("resultado", resultado);
	}
	
	@GetMapping("/formularioActualizarMatriculaciones")
	public String actualizarMatriculacion(ModelMap model) {
		
		return "matriculaciones/actualizarMatriculaciones";
	}
	
	@PostMapping("/formularioActualizarMatriculaciones")
	public String actualizarMatriculacion(
			@RequestParam(value = "nombreAlumno", required = false) String alumno,
			@RequestParam(value = "nombreAsignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha,  ModelMap model) throws SQLException {
		
		if(fecha == null || fecha.trim().isEmpty()) {
			fecha = "0001-01-01";
		}
		
		ArrayList<MatriculacionDTO> listaMatriculaciones = matriculacionesService.obtenerMatriculacionesParaId(asignatura, alumno, fecha, 1);
		
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		model.addAttribute("lista", listaMatriculaciones);
		return "matriculaciones/actualizarMatriculaciones";
	}
	
	@PostMapping(value = "/actualizarMatriculacion")
	public String modificarMatriculacion(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "alumno", required = false) Integer alumno,
			@RequestParam(value = "asignatura", required = false) Integer asignatura,
			@RequestParam(value = "tasa", required = false) Double tasa,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		Integer resultado = matriculacionesService.actualizarMatriculacion(id, alumno, asignatura, fecha, tasa);

		model.addAttribute("resultado", resultado);
		return "matriculaciones/actualizarMatriculaciones";
	}
	
	
	@GetMapping(value = "/formularioBorrarMatriculaciones")
	public String getFormularioEliminarNotas() {
		return "matriculaciones/borrarMatriculaciones";
	}

	@PostMapping(value = "/formularioBorrarMatriculaciones")
	public String formularioEliminarNotas(
			@RequestParam(value = "nombreAlumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha,  ModelMap model) throws SQLException {
		
		if(fecha == null || fecha.trim().isEmpty()) {
			fecha = "0001-01-01";
		}
		ArrayList<MatriculacionDTO> listaMatriculaciones = matriculacionesService.obtenerMatriculacionesPorFiltros(asignatura, alumno, fecha, 1);
		
		model.addAttribute("lista", listaMatriculaciones);
		return "matriculaciones/borrarMatriculaciones";
	}

	@PostMapping(value = "/borrarMatriculacion")
	public String eliminarNotas(
			@RequestParam("id") Integer id, ModelMap model) {
		Integer resultado = matriculacionesService.borrarMatriculacion(id);
		model.addAttribute("resultado", resultado);
		return "matriculaciones/borrarMatriculaciones";
	}
}
