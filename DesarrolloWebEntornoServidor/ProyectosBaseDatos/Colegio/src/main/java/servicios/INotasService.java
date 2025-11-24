package servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.NotasDTO;

public interface INotasService {

	ArrayList<NotasDTO> obtenerNotas() throws SQLException;

	ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String id_alumno, String id_asignatura, int nota,
			String fecha);

	int insertarNota(String id, String id_alumno, String id_asignatura, int nota, String fecha);

	int actualizarNota(String id, String id_alumno, String id_asignatura, int nota, String fecha);

	int borrarNota(String id);

}
