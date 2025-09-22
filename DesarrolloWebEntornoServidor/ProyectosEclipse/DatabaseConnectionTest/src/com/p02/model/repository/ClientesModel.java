package com.p02.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.p02.model.DatabaseConnection;
import com.p02.model.dto.ClienteDto;

public class ClientesModel {
	private Connection connection;

	public ClientesModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}

	public ArrayList<ClienteDto> test() {
		String query = "select * from customers";
		ArrayList<ClienteDto> listaClientes = new ArrayList<>();
		try (PreparedStatement ps1 = connection.prepareStatement(query);) {
			ResultSet rs = ps1.executeQuery();
			while (rs.next() != false) {
				ClienteDto c = new ClienteDto(rs.getString("customerName"), rs.getString("customerNumber"));
				listaClientes.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return listaClientes;
	}

}
