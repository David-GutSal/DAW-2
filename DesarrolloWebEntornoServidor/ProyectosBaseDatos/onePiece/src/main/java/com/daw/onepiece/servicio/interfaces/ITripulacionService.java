package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.dtos.TripulacionDTO;

public interface ITripulacionService {

	ArrayList<TripulacionDTO> obtenerTripulacionesPorFiltro(String id, String nombre, String barco, Boolean act);

	ArrayList<PirataDTO> obtenerMiembros(String id);

	TripulacionDTO obtenerlistaTripulacionesPorId(String id);

	int actualizarTripulacion(String idPirata, String rol, String idTripulacion);

	int eliminarDeTripulacion(Integer idPirata, Integer idTripulacion);

}
