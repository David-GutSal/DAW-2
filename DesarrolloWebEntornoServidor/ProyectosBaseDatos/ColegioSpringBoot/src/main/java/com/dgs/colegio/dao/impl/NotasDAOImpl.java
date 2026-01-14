package com.dgs.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dao.interfaces.INotasDAO;
import com.dgs.colegio.dtos.NotaDTO;
import com.dgs.colegio.entities.NotaEntity;
import com.dgs.colegio.repository.NotaRepository;

@Repository
public class NotasDAOImpl implements INotasDAO {

	@Autowired
	NotaRepository notaRepository;
	
	@Override
	public ArrayList<NotaDTO> obtenerTodasNotas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura,
			Integer nota, String fecha, int activo) {
		return notaRepository.obtenerNotasPorFiltros(idAlumno, nombreAlumno, asignatura, nota, fecha, activo);
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(Integer idAlumno, String nombreAlumno, String asignatura,
			Integer nota, int activo) {
		return notaRepository.obtenerNotasPorFiltros(idAlumno, nombreAlumno, asignatura, nota, activo);
	}

	@Override
	public int insertarNota(Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
		NotaEntity nuevaNota = new NotaEntity( idAlumno,  idAsignatura,  nota,  fecha);
		notaRepository.save(nuevaNota);
		return nuevaNota.getId();
	}

	@Override
	public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
		NotaEntity nuevaNota = new NotaEntity( id, idAlumno,  idAsignatura,  nota,  fecha);
		notaRepository.save(nuevaNota);
		return nuevaNota.getId();
	}

	@Override
	public int borrarNota(Integer id) {
		notaRepository.deleteById(id);
		return id;
	}
}
