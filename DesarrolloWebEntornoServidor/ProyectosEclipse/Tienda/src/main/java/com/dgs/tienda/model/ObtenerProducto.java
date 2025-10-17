package com.dgs.tienda.model;

import java.util.Random;

public class ObtenerProducto {
	String producto;
	public int generar() {
		Random random = new Random();
		return random.nextInt(6) + 1;
		}
	
	public String producto() {
		
		switch(generar()) {
		case 1:
			producto = "mesa";
			break;
		case 2:
			producto = "silla";
			break;
		case 3:
			producto = "rueda";
			break;
		case 4:
			producto = "raton";
			break;
		case 5:
			producto = "teclado";
			break;
		case 6:
			producto = "coche";
			break;
		default:
			producto = "No hay producto?";
			break;
		}
		return producto;
	}
}
