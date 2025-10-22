package com.dgs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.biz.IDescuento;

@Controller
public class Controlador {
	/* Fijáos que aquí también usamos la inyección de dependencias. */
	@Autowired
	IDescuento descuento;

	/*
	 * @RequestParam es la forma de recuperar los campos de un formulario en Spring
	 */
	@PostMapping("/descuento")
	public String controlador(@RequestParam("nombre") String nombre, Model model) throws IOException {
		int cantidad = descuento.calculaDescuento(nombre);
		/*
		 * El objeto Model es la forma que tiene Spring de enviar datos al front. El
		 * front podrá utilizarlos usando el nombre que le damos. En este caso:
		 * “descuento”.
		 */
		model.addAttribute("descuento", cantidad);
		model.addAttribute("nombre", nombre);
		return "descuento";
	}
}
