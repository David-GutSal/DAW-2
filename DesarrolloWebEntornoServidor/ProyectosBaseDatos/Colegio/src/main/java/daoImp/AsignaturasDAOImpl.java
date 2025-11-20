package daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IAsignaturasDAO;
import dto.AsignaturaDTO;
import utils.DBUtils;

public class AsignaturasDAOImpl implements IAsignaturasDAO {
	private static Logger logger = LoggerFactory.getLogger(AsignaturasDAOImpl.class);
	
	@Override
	public ArrayList<AsignaturaDTO> obtenerTodosAsignaturas() {
		Connection connection = DBUtils.conexion();
		ResultSet asignaturas = null;
		ArrayList<AsignaturaDTO> listaAsignaturas = new ArrayList<>();
		Statement statement;

		try {

			statement = connection.createStatement();
			asignaturas = statement.executeQuery("SELECT * FROM asignaturas");

			while (asignaturas.next()) {
				AsignaturaDTO a = new AsignaturaDTO(asignaturas.getInt(1), asignaturas.getString(2), asignaturas.getInt(3), 0);
				logger.debug("Contenido de asignatura " + a.getNombre() + " " + a.getId());
				listaAsignaturas.add(a);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAsignaturas;
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorIdNombreCursoTasa(String id, String nombre, int curso,
			int tasa, int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarAsignatura(String id, String nombre, int curso, int tasa, int activo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarAsignatura(String id, String nombre, int curso, int tasa, int activo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarAsignatura(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
