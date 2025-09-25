package com.libreria.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.libreria.controller.IMainController;
import com.libreria.controller.MainController;
import com.libreria.model.dto.ClienteDto;
import com.libreria.model.dto.Type;
import com.libreria.utils.TerminalUtils;

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
			TerminalUtils.output("1. Tabla tipo");
			TerminalUtils.output("2. Tabla publicacion");
			TerminalUtils.output("3. Tabla venta");
			TerminalUtils.output("4. Tabla Empleado");
			TerminalUtils.output("5. Tabla Usuario");
			TerminalUtils.output("6. Tabla Promocion");
			int option = TerminalUtils.inputInt();

			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				typeView();
				break;
			case 2:
				publicationView();
				break;
			case 3:
				sellView();
				break;
			case 4:
				employeView();
				break;
			default:
				TerminalUtils.output("Opcion no valida");
				break;
			}
		} while (exit);
	}

	public void typeView() {
		boolean exit = true;
		do {
			TerminalUtils.output("========== Tabla Tipo ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<Type> lista = mc.requestList();
				for (Type c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");

				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");

				break;
			case 4:
				TerminalUtils.output("========== Eliminando ==========");

				break;
			default:
				TerminalUtils.output("Opcion no valida");
				break;
			}
		} while (exit);
	}

	public void publicationView() {
		boolean exit = true;
		do {
			TerminalUtils.output("========== Tabla Publicacion ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<ClienteDto> lista = mc.requestList();
				for (ClienteDto c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");

				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");

				break;
			case 4:
				TerminalUtils.output("========== Eliminando ==========");

				break;
			default:
				TerminalUtils.output("Opcion no valida");
				break;
			}
		} while (exit);
	}

	public void sellView() {
		boolean exit = true;
		do {
			TerminalUtils.output("========== Tabla Tipo ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<ClienteDto> lista = mc.requestList();
				for (ClienteDto c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");

				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");

				break;
			case 4:
				TerminalUtils.output("========== Eliminando ==========");

				break;
			default:
				TerminalUtils.output("Opcion no valida");
				break;
			}
		} while (exit);
	}

	public void employeView() {
		boolean exit = true;
		do {
			TerminalUtils.output("========== Tabla Tipo ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<ClienteDto> lista = mc.requestList();
				for (ClienteDto c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");

				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");

				break;
			case 4:
				TerminalUtils.output("========== Eliminando ==========");

				break;
			default:
				TerminalUtils.output("Opcion no valida");
				break;
			}
		} while (exit);
	}

	public void userView() {
		boolean exit = true;
		do {
			TerminalUtils.output("========== Tabla Tipo ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<ClienteDto> lista = mc.requestList();
				for (ClienteDto c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");

				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");

				break;
			case 4:
				TerminalUtils.output("========== Eliminando ==========");

				break;
			default:
				TerminalUtils.output("Opcion no valida");
				break;
			}
		} while (exit);
	}

	public void promotionView() {
		boolean exit = true;
		do {
			TerminalUtils.output("========== Tabla Tipo ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<ClienteDto> lista = mc.requestList();
				for (ClienteDto c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");

				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");

				break;
			case 4:
				TerminalUtils.output("========== Eliminando ==========");

				break;
			default:
				TerminalUtils.output("Opcion no valida");
				break;
			}
		} while (exit);
	}

	public void crudView() {
		TerminalUtils.output("0. Salir");
		TerminalUtils.output("1. Listar");
		TerminalUtils.output("2. Añadir");
		TerminalUtils.output("3. Editar");
		TerminalUtils.output("4. Eliminar");
	}

}
