package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IDesplegableDAO;
import dto.DesplegableDTO;
import utils.DBUtils;

public class DesplegableDAOImp implements IDesplegableDAO {

	@Override
	public ArrayList<DesplegableDTO> desplegableMunicipios() {
		String sql = "SELECT * FROM municipios ORDER BY nombre";
        ArrayList<DesplegableDTO> listaMunicipios = new ArrayList<>();

        try {
            Connection connection = DBUtils.conexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	DesplegableDTO a = new DesplegableDTO(rs.getInt(1), rs.getString(5));
                listaMunicipios.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listaMunicipios;
	}
	
	@Override
	public ArrayList<DesplegableDTO> desplegableAsignaturas() {
		String sql = "SELECT * FROM asignaturas ORDER BY nombre";
		ArrayList<DesplegableDTO> listaAsignaturas = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.conexion();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				DesplegableDTO a = new DesplegableDTO(rs.getInt(1), rs.getString(5));
				listaAsignaturas.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaAsignaturas;
	}
	
	@Override
	public ArrayList<DesplegableDTO> desplegableAlumnos() {
		String sql = "SELECT * FROM alumnos ORDER BY nombre";
		ArrayList<DesplegableDTO> listaAlumnos = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.conexion();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				DesplegableDTO a = new DesplegableDTO(rs.getInt(1), rs.getString(5));
				listaAlumnos.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaAlumnos;
	}

}
