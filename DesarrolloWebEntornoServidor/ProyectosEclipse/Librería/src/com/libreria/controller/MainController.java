package com.libreria.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.libreria.model.dto.Employe;
import com.libreria.model.dto.Promotion;
import com.libreria.model.dto.Publication;
import com.libreria.model.dto.Sell;
import com.libreria.model.dto.Type;
import com.libreria.model.dto.User;
import com.libreria.model.repository.EmployeModel;
import com.libreria.model.repository.IEmploye;
import com.libreria.model.repository.IPromotion;
import com.libreria.model.repository.IPublication;
import com.libreria.model.repository.ISell;
import com.libreria.model.repository.IType;
import com.libreria.model.repository.IUser;
import com.libreria.model.repository.PromotionModel;
import com.libreria.model.repository.PublicationModel;
import com.libreria.model.repository.SellModel;
import com.libreria.model.repository.TypeModel;
import com.libreria.model.repository.UserModel;

public class MainController implements IMainController {
	private IType it;
	private IPublication ip;
	private ISell is;
	private IEmploye ie;
	private IUser iu;
	private IPromotion upr;

	public MainController() throws ClassNotFoundException, SQLException, IOException {
		this.it = new TypeModel();
		this.ip = new PublicationModel();
		this.is = new SellModel();
		this.ie = new EmployeModel();
		this.iu = new UserModel();
		this.upr = new PromotionModel();
	}

	@Override
	public ArrayList<Type> requestTypeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addType(Type t) {
		if() {
			
		}else {
			return false;
		}
		
	}

	@Override
	public boolean editType(Type t) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public ArrayList<Publication> requestPublicationList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPublication(Publication p) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public boolean editPublication(Publication p) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public ArrayList<Sell> requestSellList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addSell(Sell p) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public boolean editSell(Sell p) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteSell(Sell p) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public ArrayList<Employe> requestEmpleyeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmpleye(Employe e) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public boolean editEmpleye(Employe e) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public ArrayList<User> requestUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(User u) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public boolean editUser(User u) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public ArrayList<Promotion> requestPromotionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPromotion(Promotion p) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public boolean editPromotion(Promotion p) {
		if() {
			
		}else {
			return false;
		}
	}

	@Override
	public boolean deletePromotion(Promotion p) {
		if() {
			
		}else {
			return false;
		}
	}

}
