package com.libreria.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.libreria.model.dto.Client;
import com.libreria.model.dto.ClienteDto;
import com.libreria.model.repository.ClientesModel;
import com.libreria.model.repository.IClientModel;

public class MainController implements IMainController {
	private IClientModel cm;

	public MainController() throws ClassNotFoundException, SQLException, IOException {
		this.cm = new ClientesModel();
	}

	public ArrayList<ClienteDto> requestList() {
		ArrayList<ClienteDto> lista = cm.clientList();
		return lista;
	}

	public boolean addClient(Client c) {
		if (cm.insertClient(c)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean editClient(ClienteDto c) {
		if(cm.editClient(c)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean deleteClient(int clientNumber) {
		if(cm.deleteClient(clientNumber)) {
			return true;
		}else {
			return false;
		}
	}
}
