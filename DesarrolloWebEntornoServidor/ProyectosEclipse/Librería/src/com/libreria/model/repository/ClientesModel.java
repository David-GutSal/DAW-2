package com.libreria.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.libreria.model.DatabaseConnection;
import com.libreria.model.dto.Client;
import com.libreria.model.dto.ClienteDto;

public class ClientesModel implements IClientModel {
	private Connection connection;

	public ClientesModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}

	public ArrayList<ClienteDto> clientList() {
		String query = "select customerName, phone from customers";
		ArrayList<ClienteDto> listaClientes = new ArrayList<>();
		try (PreparedStatement ps1 = connection.prepareStatement(query);) {
			ResultSet rs = ps1.executeQuery();
			while (rs.next() != false) {
				String name = rs.getString(1);
				String number = rs.getString(2);
				;
				ClienteDto c = new ClienteDto(name, number);
				listaClientes.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return listaClientes;
	}

	public boolean insertClient(Client c) {
		String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1,"
				+ " addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setInt(1, c.getCustomerNumber());
			ps.setString(2, c.getCustomerName());
			ps.setString(3, c.getContactLastName());
			ps.setString(4, c.getContactLastName());
			ps.setString(5, c.getPhone());
			ps.setString(6, c.getAddressLine1());
			ps.setString(7, c.getAddressLine2());
			ps.setString(8, c.getCity());
			ps.setString(9, c.getState());
			ps.setString(10, c.getPostalCode());
			ps.setString(11, c.getCountry());
			ps.setInt(12, c.getSalesRepEmployeeNumber());
			ps.setDouble(13, c.getCreditLimit());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean editClient(ClienteDto c) {
		String queryUpdateCar = "UPDATE customers SET phone = ? WHERE customerName = ?";
		try (PreparedStatement ps = connection.prepareStatement(queryUpdateCar);) {

			ps.setString(1, c.getTelefono());
			ps.setString(2, c.getNombre());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteClient(int customerNumber){
		String query = "DELETE FROM customers where customerNumber = ?";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			
	        ps.setInt(1, customerNumber);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}

}
