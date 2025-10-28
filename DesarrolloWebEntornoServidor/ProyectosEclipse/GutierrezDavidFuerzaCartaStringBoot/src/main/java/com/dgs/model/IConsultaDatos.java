package com.dgs.model;

import java.io.IOException;


import com.dgs.model.entities.CartaDto;

public interface IConsultaDatos {
	CartaDto consultaCartas(String nombre) throws IOException;
}
