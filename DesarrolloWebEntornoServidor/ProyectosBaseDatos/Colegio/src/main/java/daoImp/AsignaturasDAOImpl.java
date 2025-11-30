package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.IAsignaturasDAO;
import dto.AsignaturaDTO;
import utils.DBUtils;

public class AsignaturasDAOImpl implements IAsignaturasDAO {
    
    @Override
    public ArrayList<AsignaturaDTO> obtenerTodosAsignaturas() {

        String sql = "SELECT * FROM asignaturas";
        ArrayList<AsignaturaDTO> listaAsignaturas = new ArrayList<>();

        try (Connection connection = DBUtils.conexion();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                AsignaturaDTO a = new AsignaturaDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("curso"),
                        rs.getDouble("tasa")
                );
                listaAsignaturas.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaAsignaturas;
    }


    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturasPorIdNombreCursoTasa(
            String id, String nombre, String curso, double tasa, int activo) {

        String sql = 
            "SELECT id, nombre, curso, tasa, activo " +
            "FROM asignaturas " +
            "WHERE id LIKE ? AND nombre LIKE ? AND curso LIKE ? AND tasa > ? AND activo = ?";

        ArrayList<AsignaturaDTO> lista = new ArrayList<>();

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + nombre + "%");
            ps.setString(3, "%" + curso + "%");
            ps.setDouble(4, tasa);
            ps.setInt(5, activo);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AsignaturaDTO a = new AsignaturaDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("curso"),
                        rs.getDouble("tasa")
                    );
                    lista.add(a);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public int insertarAsignatura(String id, String nombre, String curso, double tasa, int activo) {
        
        String sql =
            "INSERT INTO asignaturas (id, nombre, curso, tasa, activo) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, curso);
            ps.setDouble(4, tasa);
            ps.setInt(5, activo);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    @Override
    public int actualizarAsignatura(String id, String nombre, String curso, double tasa, int activo) {

        String sql = "UPDATE asignaturas SET nombre = ?, curso = ?, tasa = ?, activo = ? WHERE id = ?";

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, curso);
            ps.setDouble(3, tasa);
            ps.setInt(4, activo);
            ps.setString(5, id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    @Override
    public int borrarAsignatura(String id) {

        String sql = "UPDATE asignaturas SET activo = 0 WHERE id = ?";

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
