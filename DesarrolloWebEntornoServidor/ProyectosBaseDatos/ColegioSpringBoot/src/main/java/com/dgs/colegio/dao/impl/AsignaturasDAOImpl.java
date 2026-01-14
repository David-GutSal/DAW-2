package com.dgs.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dao.interfaces.IAsignaturasDAO;
import com.dgs.colegio.dtos.AsignaturaDTO;
import com.dgs.colegio.entities.AsignaturaEntity;
import com.dgs.colegio.repository.AsignaturaRepository;

@Repository
public class AsignaturasDAOImpl implements IAsignaturasDAO {

	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	@Override
	public ArrayList<AsignaturaDTO> obtenerTodasAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Double tasa, int activo) {
		return asignaturaRepository.obtenerAsignaturasPorFiltros( id,  nombre,  curso,  tasa, activo);
	}

	@Override
	public int insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
            int activo) {
		AsignaturaEntity asignatura = new AsignaturaEntity( id,  nombre,  curso.toString(),  tasa, activo);
		asignaturaRepository.save(asignatura);
		return asignatura.getId();
	}

	@Override
	public int actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
            int activo) {
		AsignaturaEntity asignatura = new AsignaturaEntity( id,  nombre,  curso.toString(),  tasa, activo);
		asignaturaRepository.save(asignatura);
		return asignatura.getId();
	}
	
	@Override
	public int borrarAsignatura(Integer id) {
		AsignaturaEntity asignatura = asignaturaRepository.findById(id).get();
		asignatura.setActivo(0);
		asignaturaRepository.save(asignatura);
		return asignatura.getId();
	}

	@Override
	public double obtenerTasaAsignatura(Integer idAsignatura) {
		AsignaturaEntity tasa = asignaturaRepository.findById(idAsignatura).get();
		if(tasa.getActivo() == 1) {
			return tasa.getTasa();
		}
		return 0;
	}

}
