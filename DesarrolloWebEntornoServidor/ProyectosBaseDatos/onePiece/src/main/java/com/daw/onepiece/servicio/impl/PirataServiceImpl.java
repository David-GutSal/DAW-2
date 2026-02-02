package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.IPirataDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;

@Service
public class PirataServiceImpl implements IPirataService{

	@Autowired
	IPirataDAO pirataDAO;
	
	@Override
	public ArrayList<PirataDTO> obtenerPiratasPorFiltro(Integer id, String nombre, String fruta, Boolean act) {
		
		return pirataDAO.obtenerPiratasPorFiltro(id, nombre, fruta, act);
	}

	@Override
	public Integer insertarPirata(String nombre, String frutaDiablo, String fechaNacimiento, Integer islas,
			Boolean act) {
		
		return pirataDAO.insertarPirata(nombre, frutaDiablo, fechaNacimiento, islas, act);
	}

	@Override
	public Integer actualizarPirata(Integer id, String nombre, String frutaDiablo, String fechaNacimiento, Integer isla,
			Boolean act) {
		return pirataDAO.actualizarPirata(id, nombre, frutaDiablo, fechaNacimiento, isla, act);
	}

	@Override
	public Integer borrarPirata(Integer id) {
		return pirataDAO.borrarPirata(id);
	}

}
