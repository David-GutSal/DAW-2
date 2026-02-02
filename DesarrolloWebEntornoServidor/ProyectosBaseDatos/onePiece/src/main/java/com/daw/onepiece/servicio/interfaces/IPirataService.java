package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;

public interface IPirataService {

	ArrayList<PirataDTO> obtenerPiratasPorFiltro(Integer id, String nombre, String fruta, Boolean act);

	Integer insertarPirata(String nombre, String frutaDiablo, String fechaNacimiento, Integer islas, Boolean act);

	Integer actualizarPirata(Integer id, String nombre, String frutaDiablo, String fechaNacimiento, Integer isla,
			Boolean act);

	Integer borrarPirata(Integer id);

}
