package com.dgs.colegio.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgs.colegio.dao.interfaces.INotasDAO;
import com.dgs.colegio.dtos.NotaDTO;
import com.dgs.colegio.service.interfaces.INotasService;

@Service
public class NotasServiceImp implements INotasService {
	@Autowired
	INotasDAO notas;

	@Override
	public ArrayList<NotaDTO> obtenerNotas() throws SQLException {
		notas.obtenerTodasNotas();
		return null;
	}

	@Override
	public int insertarNota(Integer alumno, Integer asignatura, String nota, String fecha) {
		return notas.insertarNota(alumno, asignatura, nota, fecha);
	}

	@Override
	public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
		return notas.actualizarNota(id, idAlumno, idAsignatura, nota, fecha);
	}

	@Override
	public int borrarNota(Integer id) {
		return notas.borrarNota(id);
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String nombreAsignatura,
			String nota, String fecha, Integer activo) {
		return notas.obtenerNotasPorFiltros( idAlumno,  nombreAlumno,  nombreAsignatura,
				 nota,  fecha,  activo);
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(Integer idAlumno, String nombreAlumno,
			String nombreAsignatura, String nota, Integer activo) {
		return notas.obtenerNotasPorFiltrosSinFecha(idAlumno, nombreAlumno, nombreAsignatura, nota, activo);
	}
	
 

}
