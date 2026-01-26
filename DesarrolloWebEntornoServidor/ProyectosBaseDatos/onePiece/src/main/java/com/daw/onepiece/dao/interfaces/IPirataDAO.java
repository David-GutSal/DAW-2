package com.daw.onepiece.dao.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;

public interface IPirataDAO {

	ArrayList<PirataDTO> obtenerPiratasPorFiltro(Integer id, String nombre, String fruta, Integer act);

}
