package com.daw.onepiece.servicio.interfaces;

import java.util.List;

import com.daw.onepiece.dtos.RecompensaDTO;

public interface IRecompensaService {

	List<RecompensaDTO> listarRecompensas(Integer id, String nombrePirata, Integer idTripulacion, Double cantidad,
			Integer estaVigente);

	Integer emitirRecompensa(Integer idPirata, Double cantidad);

	Integer actualizarRecompensa(Integer id, Integer idPirata, Double cantidad, Boolean estaVigente);

	Integer borrarRecompensa(Integer id);
}
