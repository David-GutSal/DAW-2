package com.dgs.colegio.service.interfaces;

import java.util.ArrayList;

import com.dgs.colegio.dtos.MatriculacionDTO;



public interface IMatriculacionesService {
	public double calcularTasa(Integer idAlumno, Integer idAsignatura);

	int insertarMatriculacion(Integer idAsignatura, Integer idAlumno,
			String fecha, Double tasa);

	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, int activo);

	int actualizarMatriculacion(Integer id, Integer idAsignatura, Integer idAlumno,
			String fecha, Double tasa);

	int borrarMatriculacion(Integer id);
}
