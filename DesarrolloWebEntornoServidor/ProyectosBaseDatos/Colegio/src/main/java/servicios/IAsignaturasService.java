package servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.AsignaturaDTO;

public interface IAsignaturasService {

	int borrarAsignatura(String id);

	ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException;

	int insertarAsignatura(String id, String nombre, String curso, double tasa, int activo);

	int actualizarAsignatura(String id, String nombre, String curso, double tasa, int activo);

	ArrayList<AsignaturaDTO> obtenerAsignaturasPorIdNombreCursoTasa(String id, String nombre, String curso, double tasa,
			int activo);


}
