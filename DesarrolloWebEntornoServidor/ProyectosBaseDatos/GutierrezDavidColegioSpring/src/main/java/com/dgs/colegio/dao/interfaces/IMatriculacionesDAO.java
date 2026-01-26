package com.dgs.colegio.dao.interfaces;

import java.sql.SQLException;

import java.util.ArrayList;

import com.dgs.colegio.dtos.MatriculacionDTO;


public interface IMatriculacionesDAO {
	double obtenerTasaAsignatura(Integer idAsignatura);

	int insertarMatriculacion(Integer idAsignatura, Integer idAlumno,
			double tasa, String fecha) throws SQLException;

	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, int activo);

	int actualizarMatriculacion(Integer id, Integer idAsignatura, Integer idAlumno,
			String fecha, Double tasa) throws SQLException;

	int borrarMatriculacion(Integer id) throws SQLException;

	ArrayList<MatriculacionDTO> obtenerMatriculacionesParaId(String asignatura, String alumno, String fecha, int i);
}
