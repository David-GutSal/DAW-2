package com.daw.onepiece.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IRecompensaDAO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.entities.RecompensaEntity;
import com.daw.onepiece.entities.TesoreriaEntity;
import com.daw.onepiece.repositorios.PirataRepository;
import com.daw.onepiece.repositorios.RecompensaRepository;
import com.daw.onepiece.repositorios.TesoreriaRepository;

@Repository
public class RecompensaDAOImpl implements IRecompensaDAO{

	@Autowired
	RecompensaRepository recompensaRepository;
	@Autowired
	PirataRepository pirataRepository;
	@Autowired
	TesoreriaRepository tesoreriaRepository;
	
	@Override
	public List<RecompensaDTO> listarRecompensas(Integer id, String nombrePirata, Integer idTripulacion, Double cantidad,
			Integer estaVigente) {
		return recompensaRepository.listarRecompensas(id, nombrePirata, idTripulacion, cantidad, estaVigente);
	}


	@Override
	public int emitirRecompensa(Integer idPirata, Double cantidad) {
		recompensaRepository.desactivarRecompensasDelPirata(idPirata);
		
		RecompensaEntity recompensa = new RecompensaEntity();
		recompensa.setPirata(pirataRepository.findById(idPirata).orElse(null));
		recompensa.setCantidad(cantidad);
		recompensa.setVigente(true);
		recompensaRepository.save(recompensa);

		TesoreriaEntity tesoreria = new TesoreriaEntity();
		tesoreria.setTipoOperacion("EMISION RECOMPENSA");
		tesoreria.setCantidad(-10000L);
		tesoreria.setFechaOperacion(LocalDateTime.now());

		tesoreriaRepository.save(tesoreria);
		
		return recompensa.getId();
		
		
		
	}


	@Override
	public Integer actualizarRecompensa(Integer id, Integer idPirata, Double cantidad, Boolean estaVigente) {
		RecompensaEntity r = recompensaRepository.findById(id).orElse(null);
		if (r == null)
			return null;

		r.setPirata(pirataRepository.findById(idPirata).orElse(null));
		r.setCantidad(cantidad);
		r.setVigente(estaVigente);

		recompensaRepository.save(r);
		return r.getId();
	}


	@Override
	public Integer borrarRecompensa(Integer id) {
		RecompensaEntity r = recompensaRepository.findById(id).orElse(null);
		if (r == null)
			return null;

		r.setVigente(false);
		recompensaRepository.save(r);
		return r.getId();
	}

}
