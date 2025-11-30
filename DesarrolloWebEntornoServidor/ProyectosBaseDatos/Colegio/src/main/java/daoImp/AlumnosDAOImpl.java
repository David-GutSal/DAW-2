package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IAlumnosDAO;
import dto.AlumnoDTO;
import utils.DBUtils;

public class AlumnosDAOImpl implements IAlumnosDAO {

    @Override
    public ArrayList<AlumnoDTO> obtenerTodosAlumnos() {

        String sql = "SELECT * FROM alumnos";
        ArrayList<AlumnoDTO> lista = new ArrayList<>();

        try (Connection connection = DBUtils.conexion();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                AlumnoDTO a = new AlumnoDTO(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("id_municipio"),
                    rs.getInt("familia_numerosa"),
                    rs.getInt("activo"),
                    rs.getInt("id_municipio")
                );
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }



    @Override
    public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(
            String id, String nombre, String apellido, int familiaNumerosa, int activo) {

        String sql =
            "SELECT a.id, a.nombre, a.apellidos, m.nombre, m.id_municipio, " +
            "a.familia_numerosa, a.activo " +
            "FROM alumnos a JOIN municipios m ON a.id_municipio = m.id_municipio " +
            "WHERE a.id LIKE ? AND a.nombre LIKE ? AND a.apellidos LIKE ? " +
            "AND a.familia_numerosa = ? AND a.activo = ?";

        ArrayList<AlumnoDTO> lista = new ArrayList<>();

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + nombre + "%");
            ps.setString(3, "%" + apellido + "%");
            ps.setInt(4, familiaNumerosa);
            ps.setInt(5, activo);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AlumnoDTO a = new AlumnoDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)
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
    public int insertarAlumno(String id, String nombre, String apellido,
                              String idMunicipio, int familiaNumerosa, int activo) {

        String sql =
            "INSERT INTO alumnos (id, nombre, apellidos, id_municipio, familia_numerosa, activo) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, idMunicipio);
            ps.setInt(5, familiaNumerosa);
            ps.setInt(6, activo);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }



    @Override
    public int actualizarAlumno(String id, String nombre, String apellido,
                                String idMunicipio, int familiaNumerosa, int activo) {

        String sql =
            "UPDATE alumnos SET nombre=?, apellidos=?, id_municipio=?, familia_numerosa=?, activo=? " +
            "WHERE id=?";

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, idMunicipio);
            ps.setInt(4, familiaNumerosa);
            ps.setInt(5, activo);
            ps.setString(6, id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }



    @Override
    public int borrarAlumno(String id) {

        String sql = "UPDATE alumnos SET activo=0 WHERE id=?";

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
