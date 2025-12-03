package servicios;

import java.util.ArrayList;

import dto.MatriculaDTO;

public interface IMatriculaService {

	ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha, String activo,
			String tasa);

}
