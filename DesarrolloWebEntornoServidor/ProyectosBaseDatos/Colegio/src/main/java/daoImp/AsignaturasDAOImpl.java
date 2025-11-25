package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				AsignaturaDTO a = new AsignaturaDTO(asignaturas.getInt(1), asignaturas.getString(2), asignaturas.getInt(3), asignaturas.getDouble(4));
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
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorIdNombreCursoTasa(String id, String nombre, String curso, double tasa, int activo) {

	    String sql = 
	        "SELECT id, nombre, curso, tasa, activo " +
	        "FROM asignaturas " +
	        "WHERE id LIKE ? AND nombre LIKE ? AND curso LIKE ? AND tasa > ? AND activo = ?";

	    ArrayList<AsignaturaDTO> lista = new ArrayList<>();

	    try (Connection connection = DBUtils.conexion();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, "%" + id + "%");
	        ps.setString(2, "%" + nombre + "%");
	        ps.setString(3, "%" +curso + "%");
	        ps.setDouble(4, tasa);
	        ps.setInt(5, activo);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            AsignaturaDTO a = new AsignaturaDTO(
	                rs.getInt("id"),
	                rs.getString("nombre"),
	                rs.getInt("curso"),
	                rs.getDouble("tasa")
	            );
	            lista.add(a);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

	@Override
	public int insertarAsignatura(String id, String nombre, String curso, double tasa, int activo) {
		String sql = "INSERT INTO asignaturas (id, nombre, curso, tasa, activo) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int resultado = 0;

		try {
			Connection connection = DBUtils.conexion();
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, curso);
			ps.setDouble(4, tasa);
			ps.setInt(5, activo);

			resultado = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public int actualizarAsignatura(String id, String nombre, String curso, double tasa, int activo) {
		String sql = "UPDATE asignaturas SET nombre = ?, curso = ?, tasa = ?, activo = ? "
				+ "WHERE id =  ? ";
		PreparedStatement ps = null;
		int resultado = 0;

		try {
			Connection connection = DBUtils.conexion();
			ps = connection.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, curso);
			ps.setDouble(3, tasa);
			ps.setInt(4, activo);
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
	public int borrarAsignatura(String id) {
		String sql = "UPDATE asignaturas SET activo = 0 "
				+ "WHERE id = ? ";
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

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorId(String idasignatura) {

	    String sql = 
	        "SELECT id, nombre" +
	        "FROM asignaturas " +
	        "WHERE id LIKE ?";

	    ArrayList<AsignaturaDTO> lista = new ArrayList<>();

	    try (Connection connection = DBUtils.conexion();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, "%" + idasignatura + "%");

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            AsignaturaDTO a = new AsignaturaDTO(
	                rs.getInt("id"),
	                rs.getString("nombre")
	            );
	            lista.add(a);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

}
