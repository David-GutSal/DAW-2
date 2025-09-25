package com.libreria.controller;

import java.util.ArrayList;

import com.libreria.model.dto.Employe;
import com.libreria.model.dto.Promotion;
import com.libreria.model.dto.Publication;
import com.libreria.model.dto.Sell;
import com.libreria.model.dto.Type;
import com.libreria.model.dto.User;

public interface IMainController {

	ArrayList<Type> requestTypeList();

	boolean addType(Type t);

	boolean editType(Type t);
	

	ArrayList<Publication> requestPublicationList();

	boolean addPublication(Publication p);

	boolean editPublication(Publication p);
	

	ArrayList<Sell> requestSellList();

	boolean addSell(Sell p);

	boolean editSell(Sell p);

	boolean deleteSell(Sell p);
	

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

}
