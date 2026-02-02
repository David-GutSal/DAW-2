package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.TripulacionDTO;

public interface ITripulacionService {

	ArrayList<TripulacionDTO> obtenerTripulacionesPorFiltro(String id, String nombre, String barco, Boolean act);

}
