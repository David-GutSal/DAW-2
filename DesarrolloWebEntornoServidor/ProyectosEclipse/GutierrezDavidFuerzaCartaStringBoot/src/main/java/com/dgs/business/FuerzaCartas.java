package com.dgs.business;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dgs.model.ConsultaDatos;
import com.dgs.model.IConsultaDatos;
import com.dgs.model.entities.CartaDto;

@Component
public class FuerzaCartas implements IFuerzaCartas {
	@Autowired
	IConsultaDatos consultaDatos;
	@Override
	public int calcularFuerzaCartas(String nombre) throws IOException {
		ConsultaDatos cd = new ConsultaDatos();
		CartaDto carta = cd.consultaCartas(nombre);
		int iFuerza = (carta.getDamage()*carta.getLife())/carta.getCost();
		return iFuerza;
	}
}
