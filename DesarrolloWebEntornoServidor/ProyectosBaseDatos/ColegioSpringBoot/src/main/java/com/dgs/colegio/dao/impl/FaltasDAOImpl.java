package com.dgs.colegio.dao.impl;

import java.util.ArrayList;

import com.dgs.colegio.dao.interfaces.IFaltasDAO;
import com.dgs.colegio.dtos.FaltaDTO;

public class FaltasDAOImpl implements IFaltasDAO {

	@Override
	public ArrayList<FaltaDTO> obtenerTodasFaltas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FaltaDTO> obtenerFaltasPorFiltros(String nombreAlumno, String asignatura, String fecha,
			int justificada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FaltaDTO> obtenerFaltasPorFiltrosSinFecha(String nombreAlumno, String asignatura,
			int justificada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarFalta(String idAlumno, String idAsignatura, String fecha, int justificada) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarFalta(String idFalta, String idAlumno, String idAsignatura, String fecha, int justificada) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarFalta(String idFalta) {
		// TODO Auto-generated method stub
		return 0;
	}

}
