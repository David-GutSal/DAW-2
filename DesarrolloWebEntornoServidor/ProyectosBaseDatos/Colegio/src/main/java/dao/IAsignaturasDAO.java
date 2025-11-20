package dao;

import java.util.ArrayList;

import dto.AsignaturaDTO;

public interface IAsignaturasDAO {

	ArrayList<AsignaturaDTO> obtenerTodosAsignaturas();

	ArrayList<AsignaturaDTO> obtenerAsignaturasPorIdNombreCursoTasa(String id, String nombre, int curso, int tasa, int activo);

	int insertarAsignatura(String id, String nombre, int curso, int tasa, int activo);

	int actualizarAsignatura(String id, String nombre, int curso, int tasa, int activo);

	int borrarAsignatura(String id);

}
