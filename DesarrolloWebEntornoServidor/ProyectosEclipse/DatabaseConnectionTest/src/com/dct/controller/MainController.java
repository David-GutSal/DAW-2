package com.dct.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dct.model.dto.Client;
import com.dct.model.dto.ClienteDto;
import com.dct.model.repository.ClientesModel;
import com.dct.model.repository.IClientModel;

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
