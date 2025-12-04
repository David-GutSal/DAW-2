package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import dao.IMatriculacionesDAO;
import dto.MatriculaDTO;
import utils.DBUtils;

public class MatriculacionesDAOImpl implements IMatriculacionesDAO {
	
	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		String sql = "SELECT tasa FROM asignaturas WHERE id = ? AND activo = 1";
		double tasa = 0.0;
		try {
			Connection connection = DBUtils.conexion();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, idAsignatura);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tasa = rs.getDouble("tasa");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasa;
	}

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha, int activo, String tasa) {

		String sql = "SELECT asig.nombre, al.nombre, m.fecha, m.activo, c.importe "
				+ "FROM matriculaciones m INNER JOIN asignaturas asig ON asig.id = m.id_asignatura INNER JOIN alumnos al ON al.id = m.id_alumno INNER JOIN caja c ON c.idmatricula = m.id "
				+ "WHERE asig.id LIKE ? AND al.id LIKE ? AND m.fecha >= ? AND m.activo = ? AND c.importe like ?";

		ArrayList<MatriculaDTO> lista = new ArrayList<>();

		try (Connection connection = DBUtils.conexion(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, "%" + asignatura);
			ps.setString(2, "%" + alumno);
			ps.setString(3, fecha);
			ps.setInt(4, activo);
			ps.setString(5, "%" + tasa + "%");

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MatriculaDTO m = new MatriculaDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
					lista.add(m);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha) {

		String sql = "SELECT m.id, asig.id, al.id, m.fecha, c.importe "
				+ "FROM matriculaciones m INNER JOIN asignaturas asig ON asig.id = m.id_asignatura INNER JOIN alumnos al ON al.id = m.id_alumno INNER JOIN caja c ON c.idmatricula = m.id "
				+ "WHERE asig.id LIKE ? AND al.id LIKE ? AND m.fecha >= ?";

		ArrayList<MatriculaDTO> lista = new ArrayList<>();

		try (Connection connection = DBUtils.conexion(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, "%" + asignatura + "%");
			ps.setString(2, "%" + alumno + "%");
			ps.setString(3, fecha);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MatriculaDTO m = new MatriculaDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					lista.add(m);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	@Override
	public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) throws SQLException {
		String sql1 = "INSERT INTO matriculaciones (id_asignatura,id_alumno, fecha, activo) VALUES (?, ?, ?, 1)";
		String sql2 = "INSERT INTO caja (idmatricula, importe) VALUES (?,?)";
		int resultado = 0;
		Connection connection = DBUtils.conexion();
		PreparedStatement statement;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, idAsignatura);
			statement.setString(2, idAlumno);
			statement.setString(3, fecha);
			int filasInsertadas = statement.executeUpdate();
			if (filasInsertadas == 0)
				throw new SQLException("Ha fallado la inserción de la matriculación");
			
			ResultSet clavesGeneradas = statement.getGeneratedKeys();
			
			int idMatriculacion;
			if (clavesGeneradas.next()) {
				idMatriculacion = clavesGeneradas.getInt(1);
			} else {
				throw new SQLException("Insert fallido, no se ha obtenidoid.");
			}
			
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement2.setInt(1, idMatriculacion);
			statement2.setString(2, tasa);
			int filasInsertadasCaja = statement2.executeUpdate();
			if (filasInsertadasCaja == 0)
				throw new SQLException("Ha fallado la inserción en caja");
			connection.commit();
			resultado = filasInsertadasCaja;
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.setAutoCommit(true);
				connection.close();
			}
		}
		return resultado;
	}

	@Override
	public int actualizarMatriculaciones(String id, String nombre, String asignatura, String fecha, String tasa) {

        String sql1 ="UPDATE matriculaciones SET id_asignatura = ?, id_alumno = ?, fecha = ? WHERE id = ?";
        String sql2 ="UPDATE caja SET importe = ? WHERE idmatricula = ?";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {

        	ps.setString(1, asignatura);
        	ps.setString(2, nombre); 
        	ps.setString(3, fecha); 
        	ps.setString(4, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection con = DBUtils.conexion();
        		PreparedStatement ps = con.prepareStatement(sql2)) {
        	
        	ps.setString(1, tasa);
        	ps.setString(4, id);
        	return ps.executeUpdate();
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }

        return 0;
    }

}
