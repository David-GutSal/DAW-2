package com.dgs.business;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dgs.model.ConsultaDatos;
import com.dgs.model.IConsultaDatos;

@Component
public class CantidadCartas implements ICantidadCartas {
	@Autowired
	IConsultaDatos consultaDatos;
	@Override
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
