package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.repositorios.TripulacionRepository;

@Repository
public class TripulacionDAOImpl implements ITripulacionDAO {

	@Autowired
	TripulacionRepository tripulacionRepository;

	@Override
	public ArrayList<TripulacionDTO> obtenerTripulacionesPorFiltro(String id, String nombre, String barco, Boolean act) {
		
		return tripulacionRepository.obtenerTripulacionesPorFiltro(id,  nombre,  barco,  act);
	}

}
