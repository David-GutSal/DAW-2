package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IMatriculacionesDAO;
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
}
