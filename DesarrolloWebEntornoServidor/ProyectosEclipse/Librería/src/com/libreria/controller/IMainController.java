package com.libreria.controller;

import java.util.ArrayList;

import com.libreria.model.entities.Employe;
import com.libreria.model.entities.Promotion;
import com.libreria.model.entities.Publication;
import com.libreria.model.entities.Sell;
import com.libreria.model.entities.Type;
import com.libreria.model.entities.User;

public interface IMainController {

	ArrayList<Type> requestTypeList();

	boolean addType(Type t);

	boolean editType(Type t);
	
/*
	ArrayList<Publication> requestPublicationList();

	boolean addPublication(Publication p);

	boolean editPublication(Publication p);
	

	ArrayList<Sell> requestSellList();

	boolean addSell(Sell p);

	boolean editSell(Sell p);

	boolean deleteSell(int id);
	

	ArrayList<Employe> requestEmpleyeList();

	boolean addEmpleye(Employe e);

	boolean editEmpleye(Employe e);
	

	ArrayList<User> requestUserList();

	boolean addUser(User u);

	boolean editUser(User u);
	

	ArrayList<Promotion> requestPromotionList();

	boolean addPromotion(Promotion p);

	boolean editPromotion(Promotion p);

	boolean deletePromotion(Promotion p);
*/
}
