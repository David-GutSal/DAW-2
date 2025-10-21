package com.dgs.appdto.biz;

import java.io.IOException;

import com.dgs.appdto.model.ConsultaDatos;

public class Descuento {
	public int calculaDescuento(String nombre) throws IOException {
		// Consultar datos
		ConsultaDatos consultaDatos = new ConsultaDatos();
		// Logica negocio con los datos obtenidos
		
		if (consultaDatos.consultaEdad(nombre) == null) {
			return 5;
		} else if (consultaDatos.consultaEdad(nombre) <20){
			return 10;
		}else {
			return 15;
		}
	}

}
