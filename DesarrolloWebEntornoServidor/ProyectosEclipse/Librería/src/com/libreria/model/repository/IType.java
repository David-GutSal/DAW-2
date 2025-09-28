package com.libreria.model.repository;

import java.util.ArrayList;

import com.libreria.model.entities.Type;

public interface IType {

	ArrayList<Type> typeList();

	boolean add(Type t);

	boolean edit(Type t);

}
