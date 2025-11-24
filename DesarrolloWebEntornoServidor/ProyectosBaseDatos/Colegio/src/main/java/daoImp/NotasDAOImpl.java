package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.INotasDAO;
import dto.NotasDTO;
import utils.DBUtils;

public class NotasDAOImpl implements INotasDAO {
	private static Logger logger = LoggerFactory.getLogger(NotasDAOImpl.class);

	@Override
	public ArrayList<NotasDTO> obtenerTodasNotas() {
		Connection connection = DBUtils.conexion();
		ResultSet notas = null;
		ArrayList<NotasDTO> listaNotas = new ArrayList<>();
		Statement statement;

		try {

			statement = connection.createStatement();
			notas = statement.executeQuery("SELECT * FROM notas");

			while (notas.next()) {
				NotasDTO a = new NotasDTO(notas.getString(1), notas.getString(2), notas.getString(3), notas.getInt(4),
						notas.getString(5));
				logger.debug("Contenido de notas " + a.getId());
				listaNotas.add(a);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaNotas;
	}

	@Override
	public ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String id_alumno, String id_asignatura, int nota,
			String fecha) {

		String sql = "SELECT id, id_alumnos, id_asignaturas, nota, fecha " + "FROM notas "
				+ "WHERE id LIKE ? AND id_alumnos LIKE ? AND id_asignaturas LIKE ? AND nota = ? AND fecha = ?";

		ArrayList<NotasDTO> lista = new ArrayList<>();

		try (Connection connection = DBUtils.conexion(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + id_alumno + "%");
			ps.setString(3, "%" + id_asignatura + "%");
			ps.setInt(4, nota);
			ps.setString(5, fecha);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NotasDTO a = new NotasDTO(rs.getString("id"), rs.getString("id_alumno"), rs.getString("id_asignatura"), rs.getInt("nota"), rs.getString("fecha"));
				lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public int insertarNota(String id, String id_alumno, String id_asignatura, int nota, String fecha) {
		String sql = "INSERT INTO notas (id, id_alumnos, id_asignaturas, nota, fecha) VALUES (?, ?, ?, ?, '?')";
		PreparedStatement ps = null;
		int resultado = 0;

		try {
			Connection connection = DBUtils.conexion();
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, id_alumno);
			ps.setString(3, id_asignatura);
			ps.setInt(4, nota);
			ps.setString(5, fecha);

			resultado = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public int actualizarNota(String id, String id_alumno, String id_asignatura, int nota, String fecha) {
		String sql = "UPDATE notas SET id_alumno = ?, curso = ?, tasa = ?, activo = ? " + "WHERE id =  ? ";
		PreparedStatement ps = null;
		int resultado = 0;

		try {
			Connection connection = DBUtils.conexion();
			ps = connection.prepareStatement(sql);
			ps.setString(1, id_alumno);
			ps.setString(2, id_asignatura);
			ps.setInt(3, nota);
			ps.setString(4, fecha);
			ps.setString(5, id);
			logger.debug("Query a ejecutar: " + ps);
			resultado = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public int borrarNota(String id) {
		String sql = "DELETE FROM notas WHERE id = ?";
		Connection connection = DBUtils.conexion();
		PreparedStatement ps;
		Integer resultado = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			logger.debug("Query a ejecutar: " + ps);
			resultado = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

}
