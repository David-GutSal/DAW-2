package com.dgs.colegio.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dao.interfaces.IMatriculacionesDAO;
import com.dgs.colegio.dtos.MatriculacionDTO;
import com.dgs.colegio.repository.MatriculacionRepository;

@Repository
public class MatriculacionesDAOImpl implements IMatriculacionesDAO {

	@Autowired
	MatriculacionRepository matriculacionRepository;
	
	@Override
	public double obtenerTasaAsignatura(Integer idAsignatura) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertarMatriculacion(Integer idAsignatura, Integer idAlumno, String fecha, Double tasa)
			throws SQLException {
		return 0;
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, int activo) {
		return matriculacionRepository.obtenerMatriculacionesPorFiltros(nombreAsignatura, nombreAlumno, fecha, activo);
	}

	@Override
	public int actualizarMatriculacion(Integer id, Integer idAsignatura, Integer idAlumno, String fecha, Double tasa)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarMatriculacion(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
