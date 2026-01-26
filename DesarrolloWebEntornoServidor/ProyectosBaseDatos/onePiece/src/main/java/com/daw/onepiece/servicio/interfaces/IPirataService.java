package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;

public interface IPirataService {

	ArrayList<PirataDTO> obtenerPiratasPorFiltro(Integer id, String nombre, String fruta, Integer act);

}
