package com.dgs.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.business.IFuerzaCartas;

@Controller
public class Controlador {
	
	@Autowired
	IFuerzaCartas fuerzaCartas;

	@PostMapping("/fuerza")
	public String controlador(@RequestParam("nombre") String nombre, Model model) throws IOException {
		int cantidad = fuerzaCartas.calcularFuerzaCartas(nombre);
		model.addAttribute("fuerza", cantidad);
		model.addAttribute("nombre", nombre);
		return "fuerza";
	}
}
