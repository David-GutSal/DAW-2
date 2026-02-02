package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Service
public class TripulacionService implements ITripulacionService {

	@Autowired
	ITripulacionDAO tripulacionDAO;
	
	@Override
	public ArrayList<TripulacionDTO> obtenerTripulacionesPorFiltro(String id, String nombre, String barco, Boolean act) {
		return tripulacionDAO.obtenerTripulacionesPorFiltro(id,  nombre,  barco,  act);
	}

}
