package com.dgs.castronegro.controlador;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.castronegro.business.AsignarRol;
import com.dgs.castronegro.model.ConsultaDatos;
import com.dgs.castronegro.model.dto.RolDTO;
import com.dgs.castronegro.model.dto.UsuarioDTO;


@Controller
public class Controlador {
	
	@GetMapping("/rol")
	public String mostrarPersonas(Model model) throws IOException {
		ConsultaDatos datos = new ConsultaDatos();
		ArrayList<UsuarioDTO> jugadores = datos.consultaJugadores();
		model.addAttribute("nombresDesplegable", jugadores);
		return "rol";
	}
	
	@PostMapping("/asignarRol")
	public String controlador(@RequestParam("persona.id") String nombre, Model model) throws IOException {
		String idJugador = ("jugadorId");
		ConsultaDatos datos = new ConsultaDatos();
		String nombreJugador = datos.getNombrePorId(Integer.parseInt(idJugador));
		AsignarRol asignar = new AsignarRol();
		RolDTO rolAsignado = asignar.asignarRolAleatorio(nombreJugador);
		
		ArrayList<UsuarioDTO> jugadores = datos.consultaJugadores();
		model.addAttribute("opcionesDesplegable", jugadores);
		model.addAttribute("rol", rolAsignado);
		model.addAttribute("nombre", nombre);
		return "rol";
	}
}
