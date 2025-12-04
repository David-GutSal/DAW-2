package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.MatriculaDTO;

public interface IMatriculacionesDAO {
	double obtenerTasaAsignatura(String idAsignatura);

	ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha, int activo,
			String tasa);

	int insertarMatriculacion(String idAsignatura, String idAlumno,
			String fecha, String tasa) throws SQLException;

	ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha);

	int actualizarMatriculaciones(String id, String nombre, String asignatura, String fecha, String tasa);
}
