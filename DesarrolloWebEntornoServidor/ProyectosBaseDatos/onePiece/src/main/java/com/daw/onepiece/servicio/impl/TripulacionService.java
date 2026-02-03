package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.PirataDTO;
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

	@Override
	public ArrayList<PirataDTO> obtenerMiembros(String id) {
		return tripulacionDAO.obtenerMiembros(id);
	}

	@Override
	public TripulacionDTO obtenerlistaTripulacionesPorId(String id) {
		return tripulacionDAO.obtenerlistaTripulacionesPorId(id);
	}

	@Override
	public int actualizarTripulacion(String idPirata, String rol, String idTripulacion) {
		return tripulacionDAO.actualizarTripulacion( idPirata,  rol,  idTripulacion);
	}

}
