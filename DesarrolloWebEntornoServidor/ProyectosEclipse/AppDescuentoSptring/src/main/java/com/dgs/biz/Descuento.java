package com.dgs.biz;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dgs.model.IConsultaDatos;

@Component
public class Descuento implements IDescuento {
	/*
	 * En la clase Descuento del paquete de negocio es donde se produce la inyección
	 * de la clase de datos.
	 * 
	 * @Autowired le dice a Spring que inserte automáticamente (inyecte) una
	 * instancia de una clase en otra. Es decir, Spring se encarga de crear el
	 * objeto y pasarlo donde se necesita, sin que tú tengas que usar new.
	 */
	@Autowired
	IConsultaDatos consultaDatos;

	@Override
	public int calculaDescuento(String nombre) throws IOException {
		if (consultaDatos.consultaEdad(nombre) == null) {
			return 5;
		} else if (consultaDatos.consultaEdad(nombre) <20){
			return 10;
		}else {
			return 15;
		}
	}
}
