package com.daw.onepiece.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Controller
@RequestMapping("/tripulaciones")
public class TripulacionController {
	@Autowired
	ITripulacionService tripulacionService;
	
	@GetMapping("/listadoTripulaciones")
	public String formularioListadoTripulaciones() {
		return "tripulaciones/listadoTripulaciones";
	}

	@PostMapping("/listadoTripulaciones")
	public String listadoTripulaciones(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "barco", required = false) String barco,
			@RequestParam(value = "estaActiva", required = false) String activo, ModelMap model) {
		
		Boolean act = (activo != null) ? true : false;
		ArrayList<TripulacionDTO> listaPiratas = tripulacionService.obtenerTripulacionesPorFiltro("" , nombre, barco, act);
		model.addAttribute("lista", listaPiratas);
		return "tripulaciones/listadoTripulaciones";
	}
	
	@GetMapping("/detallesTripulaciones")
	public String formularioDetallesTripulaciones() {
		return "tripulaciones/detallesTripulaciones";
	}
	
	@PostMapping("/detallesTripulaciones")
	public String detallesTripulaciones(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "barco", required = false) String barco,
			@RequestParam(value = "estaActiva", required = false) String activo, ModelMap model) {
		
		Boolean act = (activo != null) ? true : false;
		ArrayList<TripulacionDTO> listaPiratas = tripulacionService.obtenerTripulacionesPorFiltro(id, nombre, barco, act);
		model.addAttribute("lista", listaPiratas);
		return "tripulaciones/detallesTripulaciones";
	}
}
