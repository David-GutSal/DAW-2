package com.daw.onepiece.dao.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.dtos.TripulacionDTO;

public interface ITripulacionDAO {

	ArrayList<TripulacionDTO> obtenerTripulacionesPorFiltro(String id, String nombre, String barco, Boolean act);

	ArrayList<PirataDTO> obtenerMiembros(String id);

	TripulacionDTO obtenerlistaTripulacionesPorId(String id);

	int actualizarTripulacion(String idPirata, String rol, String idTripulacion);

	int eliminarDeTripulacion(Integer idPirata, Integer idTripulacion);

	Integer borrarTripulacion(Integer id);

	Integer actualizarTripulacion(String id, String nombre, String barco, boolean activa);

	Integer insertarTripulacion(String nombre, String barco, boolean activa);

}
