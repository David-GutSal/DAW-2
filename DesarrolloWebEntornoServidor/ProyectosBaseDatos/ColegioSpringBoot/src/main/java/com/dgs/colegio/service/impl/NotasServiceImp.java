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
	public int insertarNota(String alumno, String asignatura, String nota, String fecha) {
		return notas.insertarNota(alumno, asignatura, nota, fecha);
	}

	@Override
	public int actualizarNota(String id, String idAlumno, String idAsignatura, String nota, String fecha) {
		return notas.actualizarNota(id, idAlumno, idAsignatura, nota, fecha);
	}

	@Override
	public int borrarNota(Integer id) {
		return notas.borrarNota(id);
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String nombreAsignatura,
			String nota, String fecha, int activo) {
		return notas.obtenerNotasPorFiltros( idAlumno,  nombreAlumno,  nombreAsignatura,
				 nota,  fecha,  activo);
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(String idAlumno, String nombreAlumno,
			String nombreAsignatura, String nota, int activo) {
		return notas.obtenerNotasPorFiltrosSinFecha(idAlumno, nombreAlumno, nombreAsignatura, nota, activo);
	}
	
 

}
