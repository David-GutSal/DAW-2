package com.dct.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dct.controller.IMainController;
import com.dct.controller.MainController;
import com.dct.model.dto.Client;
import com.dct.model.dto.ClienteDto;
import com.dct.utils.TerminalUtils;

public class MainTerminalView {
	private IMainController mc;

	public MainTerminalView() throws ClassNotFoundException, SQLException, IOException {
		this.mc = new MainController();
	}

	public void start() {
		boolean exit = true;
		do {
			TerminalUtils.output("\n ========== Seleccione una opcion: ==========");
			TerminalUtils.output("0. Salir");
			TerminalUtils.output("1. Listar");
			TerminalUtils.output("2. Añadir");
			TerminalUtils.output("3. Editar");
			TerminalUtils.output("4. Eliminar");
			int option = TerminalUtils.inputInt();

			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista de clientes ==========");
				ArrayList<ClienteDto> lista = mc.requestList();
				for (ClienteDto c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo Cliente ==========");
				TerminalUtils.output("Numero de cliente:");
				int customerNumber = TerminalUtils.inputInt();
				TerminalUtils.output("Nombre de cliente:");
				String customerName = TerminalUtils.inputText();
				TerminalUtils.output("Ultimo apellido de cliente:");
				String contactLastName = TerminalUtils.inputText();
				TerminalUtils.output("Primer apellido de cliente:");
				String contactFirstName = TerminalUtils.inputText();
				TerminalUtils.output("Telefono de cliente:");
				String phone = TerminalUtils.inputText();
				TerminalUtils.output("Direccion 1 de cliente:");
				String addressLine1 = TerminalUtils.inputText();
				TerminalUtils.output("Direccion 2 de cliente:");
				String addressLine2 = TerminalUtils.inputText();
				TerminalUtils.output("Ciudad de cliente:");
				String city = TerminalUtils.inputText();
				TerminalUtils.output("Estado de cliente:");
				String state = TerminalUtils.inputText();
				TerminalUtils.output("Codigo postal de cliente:");
				String postalCode = TerminalUtils.inputText();
				TerminalUtils.output("Pais de cliente:");
				String country = TerminalUtils.inputText();
				TerminalUtils.output("Numero de representante de ventas de cliente: 1165");
				int salesRepEmployeeNumber = TerminalUtils.inputInt();
				TerminalUtils.output("Limite de credito de cliente (0.0):");
				double creditLimit = TerminalUtils.inputDoube();

				Client c = new Client(customerNumber, customerName, contactLastName, contactFirstName, phone,
						addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber,
						creditLimit);
				if (mc.addClient(c)) {
					TerminalUtils.output("Usuario agregado correctamente");
				} else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 3:
				TerminalUtils.output("========== Editando Cliente ==========");
				TerminalUtils.output("Nombre de cliente:");
				String name = TerminalUtils.inputText();
				TerminalUtils.output("Numero de cliente nuevo:");
				String newPhone = TerminalUtils.inputText();
				ClienteDto cd = new ClienteDto(name, newPhone);
				if(mc.editClient(cd)) {
					TerminalUtils.output("Usuario editado correctamente");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 4:
				TerminalUtils.output("========== Eliminando Cliente ==========");
				TerminalUtils.output("Numero de cliente:");
				int clientNumber = TerminalUtils.inputInt();
				if(mc.deleteClient(clientNumber)) {
					TerminalUtils.output("Cliente eliminado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			default:
				TerminalUtils.output("Opcion no valida");
				break;
			}
		} while (exit);
	}

}
