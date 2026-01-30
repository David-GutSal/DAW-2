package com.daw.onepiece.controladores;

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

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dtos.DesplegableDTO;
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
	@Autowired
	IDesplegablesDAO desplegables;

	@GetMapping("/listadoPiratas")
	public String formularioListadoPiratas() {
		return "piratas/listadoPiratas";
	}

	@PostMapping("/listadoPiratas")
	public String listadoPiratas(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "frutaDiablo", required = false) String frutaDiablo,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model) {
		
		Boolean act = (activo != null) ? true : false;
		ArrayList<PirataDTO> listaPiratas = pirataService.obtenerPiratasPorFiltro(id, nombre, frutaDiablo, act);
		model.addAttribute("lista", listaPiratas);
		return "piratas/listadoPiratas";
	}

	@GetMapping("/insertarPirata")
	public void insertarPirata(ModelMap model) {
		ArrayList<DesplegableDTO> listaIslas = desplegables.desplegableIslas();
		
		model.addAttribute("desplegableIslas", listaIslas);
	}
	
	@PostMapping("/insertarPirata")
	public void insertarPirata(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "frutaDiablo", required = false) String frutaDiablo,
			@RequestParam(value = "fechaNacimiento", required = false) String fechaNacimiento,
			@RequestParam(value = "islas", required = false) Integer islas,
			@RequestParam(value = "activo", required = false) String activo,  ModelMap model) throws SQLException {
		
		if (fechaNacimiento == null || fechaNacimiento.trim().isEmpty()) {
			fechaNacimiento = LocalDate.now().toString();
        }
		Boolean act = (activo != null) ? true : null;
		
		Integer resultado = pirataService.insertarPirata(nombre, frutaDiablo, fechaNacimiento, islas, act);
		
		ArrayList<DesplegableDTO> listaIslas = desplegables.desplegableIslas();
		
		model.addAttribute("desplegableIslas", listaIslas);
		model.addAttribute("resultado", resultado);
	}
	
	@GetMapping("/formularioActualizarPiratas")
	public String actualizarMatriculacion(ModelMap model) {
		ArrayList<DesplegableDTO> listaIslas = desplegables.desplegableIslas();
		model.addAttribute("desplegableIslas", listaIslas);
		return "piratas/actualizarPiratas";
	}
	
	@PostMapping("/formularioActualizarPiratas")
	public String actualizarPirata(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "frutaDiablo", required = false) String frutaDiablo,
			@RequestParam(value = "activo", required = false) String activo,  ModelMap model) throws SQLException {
		
		Boolean act = (activo != null) ? true : false;
		ArrayList<PirataDTO> listaPiratas = pirataService.obtenerPiratasPorFiltro(id, nombre, frutaDiablo, act);
		ArrayList<DesplegableDTO> listaIslas = desplegables.desplegableIslas();
		
		model.addAttribute("desplegableIslas", listaIslas);
		model.addAttribute("lista", listaPiratas);
		return "piratas/actualizarPiratas";
	}
	
	@PostMapping(value = "/actualizarPirata")
	public String modificarPirata(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "frutaDiablo", required = false) String frutaDiablo,
			@RequestParam(value = "fechaNacimiento", required = false) String fechaNacimiento,
			@RequestParam(value = "isla", required = false) Integer isla,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model) {
		
		Boolean act = (activo != null) ? true : false;
		Integer resultado = pirataService.actualizarPirata(id, nombre, frutaDiablo, fechaNacimiento, isla, act);
		ArrayList<DesplegableDTO> listaIslas = desplegables.desplegableIslas();
		
		model.addAttribute("desplegableIslas", listaIslas);
		model.addAttribute("resultado", resultado);
		return "piratas/actualizarPiratas";
	}

}
