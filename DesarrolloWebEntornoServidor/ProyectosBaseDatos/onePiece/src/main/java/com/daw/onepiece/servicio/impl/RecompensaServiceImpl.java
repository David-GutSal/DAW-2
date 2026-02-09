package com.daw.onepiece.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.IRecompensaDAO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.servicio.interfaces.IRecompensaService;

import jakarta.transaction.Transactional;

@Service
public class RecompensaServiceImpl implements IRecompensaService {

	@Autowired
	private IRecompensaDAO recompensaDAO;


	@Override
	public List<RecompensaDTO> listarRecompensas(Integer id, String nombrePirata, Integer idTripulacion, Double cantidad,
			Integer estaVigente) {
		return recompensaDAO.listarRecompensas(id, nombrePirata, idTripulacion, cantidad, estaVigente);
	}

	@Override
	@Transactional
	public Integer emitirRecompensa(Integer idPirata, Double cantidad) {
		return recompensaDAO.emitirRecompensa(idPirata, cantidad);
		
	}

	@Override
	public Integer actualizarRecompensa(Integer id, Integer idPirata, Double cantidad, Boolean estaVigente) {
		return recompensaDAO.actualizarRecompensa(id, idPirata, cantidad, estaVigente);
	}

	@Override
	public Integer borrarRecompensa(Integer id) {
		return recompensaDAO.borrarRecompensa(id);
	}
}
