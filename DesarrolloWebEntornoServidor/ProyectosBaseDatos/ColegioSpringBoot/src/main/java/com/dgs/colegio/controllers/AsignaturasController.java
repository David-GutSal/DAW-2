package com.dgs.colegio.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.colegio.dao.interfaces.IDesplegablesDAO;
import com.dgs.colegio.dtos.AsignaturaDTO;
import com.dgs.colegio.repository.AsignaturaRepository;
import com.dgs.colegio.service.interfaces.IAsignaturasService;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturasController {
	@Autowired
	IAsignaturasService asignaturaService;
	@Autowired
	IDesplegablesDAO desplegables;
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	@GetMapping("/insertarAsignatura")
	public void insertarAsignatura() {
	}

	@PostMapping("/insertarAsignatura")
	public void insertarAsignatura(
			@RequestParam("id") Integer id,
			@RequestParam("nombre") String nombre,
			@RequestParam("curso") Integer curso,
			@RequestParam("tasa") String tasa,
			@RequestParam(value = "activo", required = false) Integer activo, ModelMap model) {
		Integer act = activo != null ? 1 : 0;
		Double tasaS = (tasa != null) ? Double.parseDouble(tasa) : 0.0;
		Integer resultado = asignaturaService.insertarAsignatura(id, nombre, curso, tasaS, act);
		model.addAttribute("resultado", resultado);
	}

	@GetMapping("/listadoAsignaturas")
	public String formularioListadoAsignaturas() {
		return "asignaturas/listadoAsignaturas";
	}
	
	@PostMapping("/listadoAsignaturas")
	public String listadoAsignaturas(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) String tasa,
			@RequestParam(value = "activo", required = false) Integer activo, ModelMap model) {
		int act = (activo != null) ? 1 : 0;
		Double tasaS = (tasa != "") ? Double.parseDouble(tasa) : 0.0;
		ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturasPorFiltros(id, nombre.toString(), curso, tasaS, act);
		model.addAttribute("lista", listaAsignaturas);
		return "asignaturas/listadoAsignaturas";
	}

	@GetMapping(value = "/formularioActualizarAsignaturas")
	public String formularioModificarAsignaturas(ModelMap model) {
		return "asignaturas/actualizarAsignaturas";
	}

	@PostMapping(value = "/formularioActualizarAsignaturas")
	public String formularioModificarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) String tasa,
			@RequestParam(value = "activo", required = false) Integer activo, ModelMap model) {
		Integer act = activo != null ? 1 : 0;
		Double tasaS = (tasa != "") ? Double.parseDouble(tasa) : 0.0;
		ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturasPorFiltros(id, nombre, curso, tasaS, act);
		model.addAttribute("lista", listaAsignaturas);
		return "asignaturas/actualizarAsignaturas";
	}

	@PostMapping(value = "/actualizarAsignatura")
	public String modificarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) String tasa,
			@RequestParam(value = "activo", required = false) Integer activo, ModelMap model) {
		Integer act = activo != null ? 1 : 0;
		Double tasaS = (tasa != "") ? Double.parseDouble(tasa) : 0.0;
		Integer resultado = asignaturaService.actualizarAsignatura(id, nombre, curso, tasaS, act);
		model.addAttribute("resultado", resultado);
		return "asignaturas/actualizarAsignaturas";
	}

	@GetMapping(value = "/formularioBorrarAsignaturas")
	public String getFormularioEliminarAsignaturas() {
		return "asignaturas/borrarAsignaturas";
	}

	@PostMapping(value = "/formularioBorrarAsignaturas")
	public String formularioEliminarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) String tasa,
			@RequestParam(value = "activo", required = false) Integer activo, ModelMap model) {
		Integer act = activo != null ? 1 : 0;
		Double tasaS = (tasa != "") ? Double.parseDouble(tasa) : 0.0;
		ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturasPorFiltros(id, nombre, curso, tasaS, act);
		model.addAttribute("lista", listaAsignaturas);
		return "asignaturas/borrarAsignaturas";
	}

	@PostMapping(value = "/borrarAsignatura")
	public String eliminarAsignaturas(@RequestParam("id") Integer id, ModelMap model) {
		Integer resultado = asignaturaService.borrarAsignatura(id);
		model.addAttribute("resultado", resultado);
		return "asignaturas/borrarAsignaturas";
	}

}
