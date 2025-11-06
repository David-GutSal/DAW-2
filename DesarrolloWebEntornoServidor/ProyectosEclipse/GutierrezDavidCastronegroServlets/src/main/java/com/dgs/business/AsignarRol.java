package com.dgs.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.dgs.model.ConsultaDatos;
import com.dgs.model.dto.RolDTO;

public class AsignarRol {

	public RolDTO asignarRolAleatorio(String nombreJugador) throws IOException {
        ConsultaDatos consultaDatos = new ConsultaDatos();
        ArrayList<String> roles = consultaDatos.consultaRoles();
        Random random = new Random();
        String randomRol = roles.get(random.nextInt(roles.size()));
        return new RolDTO(randomRol, null);
    }
	
}
