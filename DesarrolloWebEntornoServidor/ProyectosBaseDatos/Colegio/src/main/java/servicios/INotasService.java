package servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.NotasDTO;

public interface INotasService {

	ArrayList<NotasDTO> obtenerNotas() throws SQLException;

	int insertarNota(String id, String id_alumno, String id_asignatura, String nota);

	int borrarNota(String id, String asignatura, String nota, String fecha);

	ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String nombre, String idasignatura, String nota, String fecha, String activo);

	ArrayList<NotasDTO> obtenerNotasFiltradas(String nombre, String asignatura, String fecha);

	int actualizarNotas(String id, String nombre, String asignatura, String nota, String fecha);

}
