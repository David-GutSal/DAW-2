package com.dgs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.business.ICantidadCartas;

@Controller
public class Controlador {
	
	@Autowired
	ICantidadCartas cantidadCartas;

	@PostMapping("/cartas")
	public String controlador(@RequestParam("nombre") String nombre, Model model) throws IOException {
		int cantidad = cantidadCartas.calcularCantidadCartas(nombre);
		
		model.addAttribute("cantidad", cantidad);
		model.addAttribute("nombre", nombre);
		return "cartas";
	}
}
