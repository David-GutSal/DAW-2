package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.INotasDAO;
import dto.NotasDTO;
import utils.DBUtils;

public class NotasDAOImpl implements INotasDAO {

    @Override
    public ArrayList<NotasDTO> obtenerTodasNotas() {

    	String sql = "SELECT al.id, al.nombre, asig.nombre, n.nota, n.fecha FROM notas n " 
    			+ "INNER JOIN alumnos al ON al.id = n.id_alumnos " 
    			+ "INNER JOIN asignaturas asig ON n.id_asignaturas = asig.id";

        ArrayList<NotasDTO> listaNotas = new ArrayList<>();

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                listaNotas.add(new NotasDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaNotas;
    }

    @Override
    public ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String nombre, String asignatura, String nota, String fecha, String activo) {

    	String sql = "SELECT al.id, al.nombre, asig.nombre, n.nota, n.fecha " 
    			+ "FROM notas n " 
    			+ "INNER JOIN alumnos al ON al.id = n.id_alumnos " 
    			+ "INNER JOIN asignaturas asig ON n.id_asignaturas = asig.id " 
    			+ "WHERE al.id like ? AND al.id like ? AND asig.id like ? AND n.nota like ? AND n.fecha >= ? AND al.activo like ?";

        ArrayList<NotasDTO> lista = new ArrayList<>();

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + nombre + "%");
            ps.setString(3, "%" + asignatura + "%");
            ps.setString(4, "%" + nota + "%");
            ps.setString(5, fecha);
            ps.setString(6, "%" + activo + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new NotasDTO(
                    		rs.getString("al.id"), 
                    		rs.getString("al.nombre"), 
                    		rs.getString("asig.nombre"), 
                    		rs.getString("n.nota"), 
                    		rs.getString("n.fecha")
                    	));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<NotasDTO> obtenerNotasFiltradas(String nombre, String asignatura, String fecha) {

    	String sql = "SELECT n.id, al.id, asig.id, n.nota, n.fecha " 
    			+ "FROM notas n " + "inner join alumnos al on al.id = n.id_alumnos " 
    			+ "INNER JOIN asignaturas asig ON n.id_asignaturas = asig.id " 
    			+ "WHERE al.id like ? AND asig.id like ? AND n.fecha >= ?";

        ArrayList<NotasDTO> lista = new ArrayList<>();

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");
            ps.setString(2, "%" + asignatura + "%");
            ps.setString(3, fecha);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new NotasDTO(
                    		rs.getString("n.id"), 
                    		rs.getString("al.id"),
                    		rs.getString("asig.id"), 
                    		rs.getString("n.nota"), 
                    		rs.getString("n.fecha")
                    	));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public int insertarNota(String alumno, String asignatura, String nota, String fecha) {

        String sql =
            "INSERT INTO notas (id_alumnos, id_asignaturas, nota, fecha) " +
            "VALUES (?, ?, ?, ?)";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, alumno);
            ps.setString(2, asignatura);
            ps.setString(3, nota);
            ps.setString(4, fecha);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int actualizarNota(String id, String alumno, String asignatura, String nota, String fecha) {

        String sql =
            "UPDATE notas SET id_alumnos = ?, id_asignaturas = ?, nota = ?, fecha = ? " +
            "WHERE id = ?";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

        	ps.setString(1, alumno); 
        	ps.setString(2, asignatura); 
        	ps.setString(3, nota); 
        	ps.setString(4, fecha); 
        	ps.setString(5, id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int borrarNota(String idAlumno, String asignatura, String nota, String fecha) {

        String sql =
            "DELETE n " +
            "FROM notas n " +
            "INNER JOIN alumnos al ON al.id = n.id_alumnos " +
            "INNER JOIN asignaturas asig ON asig.id = n.id_asignaturas " +
            "WHERE al.id LIKE ? AND asig.id LIKE ? AND n.nota LIKE ? AND n.fecha LIKE ?";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

        	ps.setString(1, idAlumno); 
        	ps.setString(2, asignatura); 
        	ps.setString(3, nota); 
        	ps.setString(4, fecha);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
