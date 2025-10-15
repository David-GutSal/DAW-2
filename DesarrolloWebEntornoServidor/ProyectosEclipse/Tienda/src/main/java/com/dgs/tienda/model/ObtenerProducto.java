package com.dgs.tienda.model;

import java.util.Random;

public class ObtenerProducto {
	private String producto;
	public int generar() {
		Random random = new Random();
		return random.nextInt(3) + 1;
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
		}
		return producto;
	}
}
