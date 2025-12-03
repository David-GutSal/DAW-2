package dao;

import java.util.ArrayList;

import dto.MatriculaDTO;

public interface IMatriculasDAO {

	ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha, String activo,
			String tasa);

}
