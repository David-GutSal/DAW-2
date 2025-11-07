package com.dgs.castronegro.business;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;

import com.dgs.castronegro.model.ConsultaDatos;
import com.dgs.castronegro.model.dto.RolDTO;


public class AsignarRol {

	public RolDTO asignarRolAleatorio(String nombreJugador) throws IOException {
        ConsultaDatos consultaDatos = new ConsultaDatos();
        ArrayList<String> roles = consultaDatos.consultaRoles();
        Random random = new Random();
        String randomRol = roles.get(random.nextInt(roles.size()));
        return new RolDTO(randomRol, null);
    }
	
}
