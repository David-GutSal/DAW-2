package com.dgs.tienda.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgs.tienda.model.ObtenerDescuento;
import com.dgs.tienda.model.ObtenerFecha;

@Controller
public class DescuentoController {
	@RequestMapping(value="/descuento")
	public String descuento(Model model) {
	
	ObtenerFecha obtener_fecha = new ObtenerFecha();
	LocalDateTime time = obtener_fecha.getTime();
	ObtenerDescuento obtener_descuento = new ObtenerDescuento();
	int descuento = obtener_descuento.generar();
	model.addAttribute("dia", time.getDayOfMonth());
	model.addAttribute("mes", time.getMonth());
	model.addAttribute("year", time.getYear());
	model.addAttribute("hora", time.getHour() + ":" +time.getMinute());
	model.addAttribute("descuento", descuento);
	
	return "descuento";
	}
}
