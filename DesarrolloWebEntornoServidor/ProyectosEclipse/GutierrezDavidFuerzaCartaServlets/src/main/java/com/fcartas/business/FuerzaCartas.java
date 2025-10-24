package com.fcartas.business;

import java.io.IOException;

import com.fcartas.model.ConsultaDatos;
import com.fcartas.model.entities.Carta;


public class FuerzaCartas {
	
	public int calcularFuerzaCartas(String nombre) throws IOException {
		ConsultaDatos cd = new ConsultaDatos();
		Carta carta = cd.consultaCartas(nombre);
		int iFuerza = (carta.getDamage()*carta.getLife())/carta.getCost();
		return iFuerza;
	}
}
