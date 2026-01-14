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
	IAlumnosDAO alumnosDAO;
	IMatriculacionesDAO matriculaciones;
	
	@Override
	public double calcularTasa(Integer idAlumno, Integer idAsignatura) {

		double tasaBase = asignaturasDAO.obtenerTasaAsignatura(idAsignatura);


		boolean esFamiliaNumerosa = alumnosDAO.esFamiliaNumerosa(idAlumno);

		double tasaFinal = tasaBase;

		if (esFamiliaNumerosa) {
			tasaFinal = tasaFinal * 0.50;
		}

		return tasaFinal;
	}

	@Override
	public int insertarMatriculacion(Integer idAsignatura, Integer idAlumno, String fecha, Double tasa) {
		try {
			return matriculaciones.insertarMatriculacion(idAsignatura, idAlumno, fecha, tasa);
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
	public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura,
			String nombreAlumno, int activo) {
		return matriculaciones.obtenerMatriculacionesPorFiltrosSinFecha(nombreAsignatura, nombreAlumno, activo);
	}

	@Override
	public int actualizarMatriculacion(Integer id, Integer idAsignatura, Integer idAlumno, String fecha, Double tasa) {
		try {
			return matriculaciones.actualizarMatriculacion(id, idAsignatura, idAlumno, fecha, tasa);
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
}
