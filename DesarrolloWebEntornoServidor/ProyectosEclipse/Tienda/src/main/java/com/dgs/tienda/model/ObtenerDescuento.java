package com.dgs.tienda.model;

import java.util.Random;

public class ObtenerDescuento {
	public int generar() {
		Random random = new Random();
		return random.nextInt(20) + 2;
		}
}
