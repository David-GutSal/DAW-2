package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IMatriculasDAO;
import dto.MatriculaDTO;
import utils.DBUtils;

public class MatriculasDAOImpl implements IMatriculasDAO{

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha, String activo, String tasa) {

		String sql = "SELECT asig.nombre, al.nombre, m.fecha, m.activo, m.tasa "
				+ "FROM matriculaciones m INNER JOIN asignaturas asig ON asig.id = m.id_asignatura INNER JOIN alumnos al ON al.id = m.id_alumno INNER JOIN caja c ON c.idmatricula = m.id"
				+ "WHERE asig.nombre LIKE ? AND al.nombre LIKE ? AND m.fecha >= ? AND m.activo LIKE ? AND c.tasa like ?";

		ArrayList<MatriculaDTO> lista = new ArrayList<>();

		try (Connection connection = DBUtils.conexion(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, "%" + asignatura + "%");
			ps.setString(2, "%" + alumno + "%");
			ps.setString(3, fecha);
			ps.setString(4, activo);
			ps.setString(5, "%" + tasa + "%");

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MatriculaDTO m = new MatriculaDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5));
					lista.add(m);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
