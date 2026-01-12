package com.dgs.colegio.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dgs.colegio.dao.interfaces.IMatriculacionesDAO;
import com.dgs.colegio.dtos.MatriculacionDTO;

public class MatriculacionesDAOImpl implements IMatriculacionesDAO {

	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura,
			String nombreAlumno, int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizarMatriculacion(String id, String idAsignatura, String idAlumno, String fecha, String tasa)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarMatriculacion(String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
