package com.dgs.colegio.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgs.colegio.dao.interfaces.IAlumnosDAO;
import com.dgs.colegio.dao.interfaces.IAsignaturasDAO;
import com.dgs.colegio.dao.interfaces.IMatriculacionesDAO;
import com.dgs.colegio.dtos.MatriculacionDTO;
import com.dgs.colegio.service.interfaces.IMatriculacionesService;

@Service
public class MatriculacionesServiceImp implements IMatriculacionesService {
	@Autowired
	IAsignaturasDAO asignaturasDAO;
	@Autowired
	IAlumnosDAO alumnosDAO;
	@Autowired
	IMatriculacionesDAO matriculaciones;
	
	@Override
	public double calcularTasa(Integer idAsignatura, Integer idAlumno) {

		double tasaBase = asignaturasDAO.obtenerTasaAsignatura(idAsignatura);

		boolean esFamiliaNumerosa = alumnosDAO.esFamiliaNumerosa(idAlumno);

		double tasaFinal = tasaBase;
		
		if (esFamiliaNumerosa) {
			tasaFinal = tasaFinal * 0.50;
		}

		return tasaFinal;
	}

	@Override
	public int insertarMatriculacion(Integer alumno, Integer asignatura, double tasa, String fecha) {
		try {
			return matriculaciones.insertarMatriculacion(alumno, asignatura, tasa, fecha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, int activo) {
		return matriculaciones.obtenerMatriculacionesPorFiltros(nombreAsignatura, nombreAlumno, fecha, activo);
	}

	@Override
	public int actualizarMatriculacion(Integer id, Integer idAlumno, Integer idAsignatura, String fecha, Double tasa) {
		try {
			return matriculaciones.actualizarMatriculacion(id, idAlumno, idAsignatura, fecha, tasa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int borrarMatriculacion(Integer id) {
		try {
			return matriculaciones.borrarMatriculacion(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesParaId(String asignatura, String alumno, String fecha,
			int i) {
		return matriculaciones.obtenerMatriculacionesParaId(asignatura, alumno, fecha, i);
	}
}
