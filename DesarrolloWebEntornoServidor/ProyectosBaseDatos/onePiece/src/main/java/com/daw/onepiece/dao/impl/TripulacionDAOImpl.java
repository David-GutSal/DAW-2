package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.entities.ReclutamientoEntity;
import com.daw.onepiece.entities.TripulacionEntity;
import com.daw.onepiece.repositorios.PirataRepository;
import com.daw.onepiece.repositorios.ReclutamientoRepository;
import com.daw.onepiece.repositorios.TripulacionRepository;

@Repository
public class TripulacionDAOImpl implements ITripulacionDAO {

	@Autowired
	TripulacionRepository tripulacionRepository;
	@Autowired
	PirataRepository pirataRepository;
	@Autowired
	ReclutamientoRepository reclutaminetoRepository;

	@Override
	public ArrayList<TripulacionDTO> obtenerTripulacionesPorFiltro(String id, String nombre, String barco, Boolean act) {
		
		return tripulacionRepository.obtenerTripulacionesPorFiltro(id,  nombre,  barco,  act);
	}

	@Override
	public ArrayList<PirataDTO> obtenerMiembros(String id) {
		return tripulacionRepository.obtenerMiembros(id);
	}

	@Override
	public TripulacionDTO obtenerlistaTripulacionesPorId(String id) {
		TripulacionEntity tripulacion = tripulacionRepository.findById(Integer.parseInt(id)).get();
		TripulacionDTO tripulacionDto = new TripulacionDTO(tripulacion.getId(), tripulacion.getNombre(), tripulacion.getBarco(), tripulacion.getActivo());
		return tripulacionDto;
	}

	@Override
	public int actualizarTripulacion(String idPirata, String rol, String idTripulacion) {
		TripulacionEntity tripulacion = tripulacionRepository.findById(Integer.parseInt(idTripulacion)).get();
		PirataEntity pirata = pirataRepository.findById(Integer.parseInt(idPirata)).get();
		ReclutamientoEntity recluta = new ReclutamientoEntity(pirata, tripulacion, rol, true);
		reclutaminetoRepository.save(recluta);
		return Integer.parseInt(idTripulacion);
	}

	@Override
	public int eliminarDeTripulacion(Integer idPirata, Integer idTripulacion) {
		ReclutamientoEntity recluta = reclutaminetoRepository.buscarMiembro(idPirata, idTripulacion);
		recluta.setEsMiembroActual(false);
		reclutaminetoRepository.save(recluta);
		return idTripulacion;
	}

}
