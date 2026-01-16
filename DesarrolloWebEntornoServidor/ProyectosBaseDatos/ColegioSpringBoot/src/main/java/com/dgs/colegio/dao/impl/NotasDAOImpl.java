package com.dgs.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dao.interfaces.INotasDAO;
import com.dgs.colegio.dtos.NotaDTO;
import com.dgs.colegio.entities.AlumnoEntity;
import com.dgs.colegio.entities.AsignaturaEntity;
import com.dgs.colegio.entities.NotaEntity;
import com.dgs.colegio.repository.AlumnoRepository;
import com.dgs.colegio.repository.AsignaturaRepository;
import com.dgs.colegio.repository.NotaRepository;

@Repository
public class NotasDAOImpl implements INotasDAO {

	@Autowired
	NotaRepository notaRepository;
	AlumnoRepository alumnoRepository;
	AsignaturaRepository asignaturaRepository;
	
	@Override
	public ArrayList<NotaDTO> obtenerTodasNotas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String nombreAsignatura, String nota, String fecha, Integer act) {
		return notaRepository.obtenerNotasPorFiltros(idAlumno, nombreAlumno, nombreAsignatura, nota, fecha, act);
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(Integer idAlumno, String nombreAlumno, String nombreAsignatura, String nota, Integer act) {
		return notaRepository.obtenerNotasPorFiltrosSinFecha(idAlumno, nombreAlumno, nombreAsignatura, nota, act);
	}

	@Override
	public int insertarNota(Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
		AlumnoEntity idAl = alumnoRepository.findById(idAlumno).get();
		AsignaturaEntity idAs = asignaturaRepository.findById(idAsignatura).get();
		NotaEntity nuevaNota = new NotaEntity( idAl,  idAs,  nota,  fecha);
		notaRepository.save(nuevaNota);
		return nuevaNota.getId();
	}

	@Override
	public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
		AlumnoEntity idAl = alumnoRepository.findById(idAlumno).get();
		AsignaturaEntity idAs = asignaturaRepository.findById(idAsignatura).get();
		
		NotaEntity nuevaNota = new NotaEntity( id, idAl,  idAs,  nota,  fecha);
		notaRepository.save(nuevaNota);
		return nuevaNota.getId();
	}

	@Override
	public int borrarNota(Integer id) {
		notaRepository.deleteById(id);
		return id;
	}
}
