package com.daw.onepiece.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Controller
@RequestMapping("/tripulaciones")
public class TripulacionController {
	@Autowired
	ITripulacionService tripulacionService;
	@Autowired
	IPirataService pirataService;
	
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
		ArrayList<TripulacionDTO> listaTripulaciones = tripulacionService.obtenerTripulacionesPorFiltro("" , nombre, barco, act);
		model.addAttribute("lista", listaTripulaciones);
		return "tripulaciones/listadoTripulaciones";
	}
	
	@GetMapping("/detallesTripulacion")
	public String formularioDetallesTripulaciones(
			@RequestParam("id") String id, ModelMap model) {
	
	    ArrayList<PirataDTO> listaPiratas = tripulacionService.obtenerMiembros(id);	
	    TripulacionDTO tripulacion = tripulacionService.obtenerlistaTripulacionesPorId(id);
	    
	    model.addAttribute("tripulacion", tripulacion);
	    model.addAttribute("miembros", listaPiratas);
	    
	    ArrayList<PirataDTO> piratasActivos = pirataService.obtenerPiratasPorFiltro(null, "", null, true); 
	    model.addAttribute("piratasActivos", piratasActivos);
    
    return "tripulaciones/detallesTripulacion";
	}
	
	@PostMapping("/agregarMiembro")
	public String formularioAgregarNuevoMiembro(
			@RequestParam("idPirata") String idPirata,
			@RequestParam("idTripulacion") String idTripulacion,
			@RequestParam("rol") String rol, ModelMap model) {
		
		int resultado = tripulacionService.actualizarTripulacion(idPirata, rol, idTripulacion);
		
	    ArrayList<PirataDTO> listaPiratas = tripulacionService.obtenerMiembros(idTripulacion);	
	    TripulacionDTO tripulacion = tripulacionService.obtenerlistaTripulacionesPorId(idTripulacion);
	    
	    model.addAttribute("tripulacion", tripulacion);
	    model.addAttribute("miembros", listaPiratas);
	    
	    ArrayList<PirataDTO> piratasActivos = pirataService.obtenerPiratasPorFiltro(null, "", null, true); 
	    model.addAttribute("piratasActivos", piratasActivos);
		
		model.addAttribute("resultado", resultado);
		return "tripulaciones/detallesTripulacion";
	}
	
	@PostMapping("/eliminarMiembro")
	public String formularioEliminarNuevoMiembro(
			@RequestParam("idPirata") Integer idPirata,
			@RequestParam("idTripulacion") Integer idTripulacion, ModelMap model) {
		
		int resultado = tripulacionService.eliminarDeTripulacion(idPirata, idTripulacion);
		
		ArrayList<PirataDTO> listaPiratas = tripulacionService.obtenerMiembros(String.valueOf(idTripulacion));	
		TripulacionDTO tripulacion = tripulacionService.obtenerlistaTripulacionesPorId(String.valueOf(idTripulacion));
		
		model.addAttribute("tripulacion", tripulacion);
		model.addAttribute("miembros", listaPiratas);
		
		ArrayList<PirataDTO> piratasActivos = pirataService.obtenerPiratasPorFiltro(null, "", null, true); 
		model.addAttribute("piratasActivos", piratasActivos);
		
		model.addAttribute("resultado", resultado);
		return "tripulaciones/detallesTripulacion";
	}
}
