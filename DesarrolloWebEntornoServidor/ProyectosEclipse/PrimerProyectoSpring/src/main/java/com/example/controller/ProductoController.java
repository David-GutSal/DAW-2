package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgs.tienda.model.ObtenerProducto;

@Controller
public class ProductoController {
	@RequestMapping(value="/product")
	public String Info() {
		return "producto";
	}
	
	@RequestMapping(value="/producto")
	public String producto(Model model) {
	
	ObtenerProducto valor_producto = new ObtenerProducto();
	
	String producto = valor_producto.producto();
	
	model.addAttribute("productoGenerado", producto);
	
	return "producto";
	}

}
