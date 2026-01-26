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
import com.daw.onepiece.repositorios.PirataRepository;
import com.daw.onepiece.servicio.interfaces.IPirataService;

@Controller
@RequestMapping("/piratas")
public class PirataController {
	@Autowired
	IPirataService pirataService;
	@Autowired
	PirataRepository pirataRepository;

	@GetMapping("/listadoPiratas")
	public String formularioListadoPiratas() {
		return "piratas/listadoPiratas";
	}

	@PostMapping("/listadoPiratas")
	public String listadoPiratas(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "fruta", required = false) String fruta,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model) {
		
		Integer act = (activo != null) ? 1 : 0;
		ArrayList<PirataDTO> listaPiratas = pirataService.obtenerPiratasPorFiltro(id, nombre, fruta, act);
		model.addAttribute("lista", listaPiratas);
		return "piratas/listadoPiratas";
	}



}
