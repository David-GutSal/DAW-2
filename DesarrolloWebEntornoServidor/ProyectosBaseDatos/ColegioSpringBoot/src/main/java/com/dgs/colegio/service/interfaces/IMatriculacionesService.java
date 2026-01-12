package com.dgs.colegio.service.interfaces;

import java.util.ArrayList;

import com.dgs.colegio.dtos.MatriculacionDTO;



public interface IMatriculacionesService {
	public double calcularTasa(Integer idAlumno, Integer idAsignatura);

	int insertarMatriculacion(String idAsignatura, String idAlumno,
			String fecha, String tasa);

	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, int activo);

	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura, String nombreAlumno,
			int activo);

	int actualizarMatriculacion(String id, String idAsignatura, String idAlumno,
			String fecha, String tasa);

	int borrarMatriculacion(String id);
}
