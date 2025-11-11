package com.dgs.castronegro.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgs.castronegro.model.IConsultaDatos;
import com.dgs.castronegro.model.dto.RolDTO;

@Service
public class AsignarRol {

    @Autowired
    private IConsultaDatos consultaDatos;

    public RolDTO asignarRolAleatorio(String nombreJugador) throws IOException {
        ArrayList<String> roles = consultaDatos.consultaRoles();
        Random random = new Random();
        String randomRol = roles.get(random.nextInt(roles.size()));
        return new RolDTO(randomRol, null);
    }
}
