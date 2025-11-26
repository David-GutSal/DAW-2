package servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.NotasDTO;

public interface INotasService {

	ArrayList<NotasDTO> obtenerNotas() throws SQLException;

	int insertarNota(String id, String id_alumno, String id_asignatura, String nota, String fecha);

	int actualizarNota(String id, String id_alumno, String id_asignatura, String nota, String fecha);

	int borrarNota(String id);

	ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String nombre, String idasignatura, String nota, String fecha, String activo);

}
