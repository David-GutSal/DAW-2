package com.dgs.castronegro.model;

import java.io.IOException;
import java.util.ArrayList;
import com.dgs.castronegro.model.dto.UsuarioDTO;

public interface IConsultaDatos {
    ArrayList<UsuarioDTO> consultaJugadores() throws IOException;
    ArrayList<String> consultaRoles() throws IOException;
    String getNombrePorId(int id) throws IOException;
}
