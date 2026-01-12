package com.dgs.colegio.dao.impl;

import java.util.ArrayList;

import com.dgs.colegio.dao.interfaces.INotasDAO;
import com.dgs.colegio.dtos.NotaDTO;

public class NotasDAOImpl implements INotasDAO {

	@Override
	public ArrayList<NotaDTO> obtenerTodasNotas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(String idAlumno, String nombreAlumno, String asignatura,
			String nota, String fecha, int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(String idAlumno, String nombreAlumno, String asignatura,
			String nota, int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarNota(String idAlumno, String idAsignatura, String nota, String fecha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarNota(String id, String idAlumno, String idAsignatura, String nota, String fecha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarNota(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
