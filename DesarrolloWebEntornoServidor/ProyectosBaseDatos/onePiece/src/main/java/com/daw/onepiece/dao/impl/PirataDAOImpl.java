package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IPirataDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.repositorios.PirataRepository;

@Repository
public class PirataDAOImpl implements IPirataDAO{

	@Autowired
	PirataRepository pirataRepository;
	
	@Override
	public ArrayList<PirataDTO> obtenerPiratasPorFiltro(Integer id, String nombre, String fruta, Integer act) {
		return pirataRepository.obtenerPiratasPorFiltro(id, nombre, fruta, act);
	}

}
