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
	public ArrayList<PirataDTO> obtenerPiratasPorFiltro(Integer id, String nombre, String fruta, Integer act) {
		
		return pirataDAO.obtenerPiratasPorFiltro(id, nombre, fruta, act);
	}

}
