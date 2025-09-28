package com.libreria.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.libreria.model.DatabaseConnection;
import com.libreria.model.entities.Type;

public class TypeModel implements IType {
	private Connection connection;

	public TypeModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}

	@Override
	public ArrayList<Type> typeList() {
		String query = "select * from tipo";
		ArrayList<Type> listaType = new ArrayList<>();
		try (PreparedStatement ps1 = connection.prepareStatement(query);) {
			ResultSet rs = ps1.executeQuery();
			while (rs.next() != false) {
				String idType = rs.getString(1);
				String description = rs.getString(2);
				;
				Type c = new Type(idType, description);
				listaType.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return listaType;
	}

	@Override
	public boolean add(Type t) {
		String query = "INSERT INTO tipo (idtipo, descripcion) " + "VALUES (?, ?)";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, t.getIdType());
			ps.setString(2, t.getDescription());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean edit(Type t) {
		String query = "UPDATE tipo SET descripcion = ? WHERE idtipo = ?";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, t.getDescription());
			ps.setString(2, t.getIdType());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}