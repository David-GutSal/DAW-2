package servicios;

import java.util.ArrayList;

import dto.MatriculaDTO;

public interface IMatriculacionesService {
	public double calcularTasa(String idAlumno, String idAsignatura);
	
	int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa);
	
	ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha, int activo,
			String tasa);

	public ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String alumno, String asignatura, String fecha);

	public int actualizarMatriculaciones(String id, String nombre, String asignatura, String fecha, String tasa);

	public int borrarMatricula(String id);

}
