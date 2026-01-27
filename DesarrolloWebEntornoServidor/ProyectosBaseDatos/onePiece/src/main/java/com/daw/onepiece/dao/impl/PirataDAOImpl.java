package com.daw.onepiece.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IPirataDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.entities.IslaEntity;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.repositorios.IslaRepository;
import com.daw.onepiece.repositorios.PirataRepository;

@Repository
public class PirataDAOImpl implements IPirataDAO{

	@Autowired
	PirataRepository pirataRepository;
	@Autowired
	IslaRepository islaRepository;
	
	@Override
	public ArrayList<PirataDTO> obtenerPiratasPorFiltro(Integer id, String nombre, String fruta, Boolean act) {
		return pirataRepository.obtenerPiratasPorFiltro(id, nombre, fruta, act);
	}

	@Override
	public Integer insertarPirata(String nombre, String frutaDiablo, String fechaNacimiento, Integer islas,
			Boolean act) {
		IslaEntity isla = islaRepository.findById(islas).get();
		
		PirataEntity pirata = new PirataEntity(nombre, frutaDiablo, LocalDate.parse(fechaNacimiento), isla, act);
		pirataRepository.save(pirata);
		
		return pirata.getId();
	}

}
