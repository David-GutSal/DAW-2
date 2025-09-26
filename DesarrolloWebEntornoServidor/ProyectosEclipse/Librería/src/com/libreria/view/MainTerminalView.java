package com.libreria.view;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import com.libreria.controller.IMainController;
import com.libreria.controller.MainController;
import com.libreria.model.dto.Employe;
import com.libreria.model.dto.Promotion;
import com.libreria.model.dto.Publication;
import com.libreria.model.dto.Sell;
import com.libreria.model.dto.Type;
import com.libreria.model.dto.User;
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
				ArrayList<Type> lista = mc.requestTypeList();
				for (Type c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");
				TerminalUtils.output("Id:");
				String idType = TerminalUtils.inputText();
				TerminalUtils.output("Descripcion:");
				String description = TerminalUtils.inputText();
				Type t = new Type(idType, description);
				if(mc.addType(t)) {
					TerminalUtils.output("Tipo agregado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");
				String searchIdType = TerminalUtils.inputText();
				String newDescription = TerminalUtils.inputText();
				Type editedType = new Type(searchIdType, newDescription);
				if(mc.editType(editedType)) {
					TerminalUtils.output("Tipo editado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 4:
				TerminalUtils.output("No se pueden eliminar tipos");
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
				ArrayList<Publication> lista = mc.requestPublicationList();
				for (Publication c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");
				TerminalUtils.output("Id:");
				String id = TerminalUtils.inputText();
				TerminalUtils.output("Titulo:");
				String title = TerminalUtils.inputText();
				TerminalUtils.output("Autor:");
				String author = TerminalUtils.inputText();
				TerminalUtils.output("Numero de Edicion:");
				int edition = TerminalUtils.inputInt();
				TerminalUtils.output("Precio:");
				double price = TerminalUtils.inputDoube();
				TerminalUtils.output("Stock:");
				int stock = TerminalUtils.inputInt();
				TerminalUtils.output("Id tipo:");
				String idType = TerminalUtils.inputText();
				Publication p = new Publication(id, title, author, edition, price, stock, idType);
				if(mc.addPublication(p)) {
					TerminalUtils.output("Tipo agregado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");
				TerminalUtils.output("Id:");
				String newId = TerminalUtils.inputText();
				TerminalUtils.output("Titulo:");
				String newtitle = TerminalUtils.inputText();
				TerminalUtils.output("Autor:");
				String newauthor = TerminalUtils.inputText();
				TerminalUtils.output("Numero de Edicion:");
				int newedition = TerminalUtils.inputInt();
				TerminalUtils.output("Precio:");
				double newprice = TerminalUtils.inputDoube();
				TerminalUtils.output("Stock:");
				int newstock = TerminalUtils.inputInt();
				TerminalUtils.output("Id tipo:");
				String newidType = TerminalUtils.inputText();
				Publication newp = new Publication(newId, newtitle, newauthor, newedition, newprice, newstock, newidType);
				if(mc.editPublication(newp)) {
					TerminalUtils.output("Tipo editado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 4:
				TerminalUtils.output("No se pueden eliminar tipos");
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
			TerminalUtils.output("========== Tabla Ventas ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<Sell> lista = mc.requestSellList();
				for (Sell c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");
				if(mc.addSell(null)) {
					TerminalUtils.output("Tipo agregado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");
				if(mc.editSell(null)) {
					TerminalUtils.output("Tipo editado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 4:
				TerminalUtils.output("========== Eliminando ==========");
				if(mc.deleteSell(null)) {
					TerminalUtils.output("Tipo eliminado");
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

	public void employeView() {
		boolean exit = true;
		do {
			TerminalUtils.output("========== Tabla Empleado ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<Employe> lista = mc.requestEmpleyeList();
				for (Employe c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");
				if(mc.addEmpleye(null)) {
					TerminalUtils.output("Tipo agregado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");
				if(mc.editEmpleye(null)) {
					TerminalUtils.output("Tipo editado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 4:
				TerminalUtils.output("No se pueden eliminar tipos");
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
			TerminalUtils.output("========== Tabla Usuario ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<User> lista = mc.requestUserList();
				for (User c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");
				if(mc.addUser(null)) {
					TerminalUtils.output("Tipo agregado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");
				if(mc.editUser(null)) {
					TerminalUtils.output("Tipo editado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 4:
				TerminalUtils.output("No se pueden eliminar tipos");
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
			TerminalUtils.output("========== Tabla Promocion ==========");
			crudView();
			int option = TerminalUtils.inputInt();
			switch (option) {
			case 0:
				exit = false;
				TerminalUtils.output("Adios!!!");
				break;
			case 1:
				TerminalUtils.output("========== Lista ==========");
				ArrayList<Promotion> lista = mc.requestPromotionList();
				for (Promotion c : lista) {
					TerminalUtils.output(c.toString());
				}
				break;
			case 2:
				TerminalUtils.output("========== Añadiendo ==========");
				if(mc.addPromotion(null)) {
					TerminalUtils.output("Tipo agregado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 3:
				TerminalUtils.output("========== Editando ==========");
				if(mc.editPromotion(null)) {
					TerminalUtils.output("Tipo editado");
				}else {
					TerminalUtils.output("Algo salio mal");
				}
				break;
			case 4:
				TerminalUtils.output("========== Eliminando ==========");
				if(mc.deletePromotion(null)) {
					TerminalUtils.output("Tipo eliminado");
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

	public void crudView() {
		TerminalUtils.output("0. Salir");
		TerminalUtils.output("1. Listar");
		TerminalUtils.output("2. Añadir");
		TerminalUtils.output("3. Editar");
		TerminalUtils.output("4. Eliminar");
	}

}
