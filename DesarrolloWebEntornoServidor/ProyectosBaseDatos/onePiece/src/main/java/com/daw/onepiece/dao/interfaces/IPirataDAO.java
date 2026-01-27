package com.daw.onepiece.dao.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;

public interface IPirataDAO {

	ArrayList<PirataDTO> obtenerPiratasPorFiltro(Integer id, String nombre, String fruta, Boolean act);

	Integer insertarPirata(String nombre, String frutaDiablo, String fechaNacimiento, Integer islas, Boolean act);

}
