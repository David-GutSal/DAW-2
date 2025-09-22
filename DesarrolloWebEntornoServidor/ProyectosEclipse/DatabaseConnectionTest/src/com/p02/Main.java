package com.p02;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.p02.model.dto.ClienteDto;
import com.p02.model.repository.ClientesModel;

public class Main {
	public static void main(String[] arg) throws ClassNotFoundException, SQLException, IOException {
		ClientesModel cm = new ClientesModel();
		ArrayList<ClienteDto> lista = cm.test();
		for(ClienteDto c: lista) {
			System.out.println(c.toString());
		}
		
	}	
}
