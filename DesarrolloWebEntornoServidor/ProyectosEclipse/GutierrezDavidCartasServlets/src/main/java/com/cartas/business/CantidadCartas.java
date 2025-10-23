package com.cartas.business;

import java.io.IOException;
import java.util.ArrayList;

import com.cartas.model.ConsultaDatos;

public class CantidadCartas {
	
	public int calcularCantidadCartas(String nombre) throws IOException {

		ConsultaDatos cd = new ConsultaDatos();
		ArrayList<String> cartas = cd.consultaCartas(nombre);
		int cantidad = 0;
		for(int i = 0; i< cartas.size(); i++) {
			cantidad++;
		}
		return cantidad;
	}
}
