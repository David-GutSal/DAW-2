package com.daw.onepiece.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;
import com.daw.onepiece.servicio.interfaces.IRecompensaService;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Controller
@RequestMapping("/recompensas")
public class RecompensasController {

	@Autowired
	private IRecompensaService recompensaService;

	@Autowired
	private IPirataService piratasService;

	@Autowired
	private ITripulacionService tripulacionesService;

	@GetMapping("/listadoRecompensas")
	public String listado(ModelMap model) {
		model.addAttribute("tripulacionesActivas",
				tripulacionesService.obtenerTripulacionesPorFiltro(null, null, null, true));
		return "recompensas/listadoRecompensas";
	}

	@PostMapping("/listadoRecompensas")
	public String listadoPost(
			@RequestParam(value = "nombrePirata", required = false) String nombrePirata,
			@RequestParam(value = "idTripulacion", required = false) Integer idTripulacion, 
			@RequestParam(value = "cantidad", required = false) Double cantidad,
			@RequestParam(value = "estaVigente", required = false) Integer activo, ModelMap model) {

		Integer act = (activo != null) ? 1 : 0;
		List<RecompensaDTO> listaRecompensas = recompensaService.listarRecompensas(null, nombrePirata, idTripulacion, cantidad, act);
		List<TripulacionDTO> listaTripulaciones = tripulacionesService.obtenerTripulacionesPorFiltro(null, null, null, true);
		
		model.addAttribute("lista", listaRecompensas);
		model.addAttribute("tripulacionesActivas", listaTripulaciones);
		return "recompensas/listadoRecompensas";
	}

	@GetMapping("/emitirRecompensa")
	public String emitir(
			ModelMap model) {
		model.addAttribute("piratasActivos", piratasService.obtenerPiratasPorFiltro(null, null, null, true));
		return "recompensas/emitirRecompensa";
	}

	@PostMapping("/emitirRecompensa")
	public String emitirPost(
			@RequestParam Integer idPirata, 
			@RequestParam Double cantidad, ModelMap model) {
		
		Integer id = recompensaService.emitirRecompensa(idPirata, cantidad);
		
		model.addAttribute("resultado", id);
		model.addAttribute("piratasActivos", piratasService.obtenerPiratasPorFiltro(null, null, null, true));
		return "recompensas/emitirRecompensa";
	}

	@GetMapping("/formularioActualizarRecompensas")
	public String actualizar() {
		return "recompensas/actualizarRecompensas";
	}

	@PostMapping("/formularioActualizarRecompensas")
	public String buscarActualizar(
			@RequestParam(required = false) Integer id,
			@RequestParam(required = false) String nombrePirata, 
			@RequestParam(required = false) Integer estaVigente,
			ModelMap model) {

		Integer act = (estaVigente != null) ? 1 : 0;
		model.addAttribute("lista", recompensaService.listarRecompensas(id, nombrePirata, null, null, act));

		model.addAttribute("piratasActivos", piratasService.obtenerPiratasPorFiltro(null, null, null, true));
		return "recompensas/actualizarRecompensas";
	}

	@PostMapping("/actualizarRecompensa")
	public String actualizarPost(
			@RequestParam Integer id, 
			@RequestParam Integer idPirata, 
			@RequestParam Double cantidad,
			@RequestParam(required = false) Integer estaVigente, ModelMap model) {

		model.addAttribute("resultado",
				recompensaService.actualizarRecompensa(id, idPirata, cantidad, estaVigente != null));

		return "redirect:/recompensas/formularioActualizarRecompensas";
	}

	@GetMapping("/formularioBorrarRecompensas")
	public String borrar() {
		return "recompensas/borrarRecompensas";
	}

	@PostMapping("/formularioBorrarRecompensas")
	public String buscarBorrar(
			@RequestParam(required = false) Integer id,
			@RequestParam(required = false) String nombrePirata, ModelMap model) {

		model.addAttribute("lista", recompensaService.listarRecompensas(id, nombrePirata, null, null, 1));

		return "recompensas/borrarRecompensas";
	}

	@PostMapping("/borrarRecompensa")
	public String borrarPost(
			@RequestParam Integer id, ModelMap model) {

		model.addAttribute("resultado", recompensaService.borrarRecompensa(id));
		return "redirect:/recompensas/formularioBorrarRecompensas";
	}
}
