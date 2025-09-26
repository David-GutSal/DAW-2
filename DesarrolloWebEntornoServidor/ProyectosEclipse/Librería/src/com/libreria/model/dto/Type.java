package com.libreria.model.dto;


public class Type{
	private int idType;
	private String description;
	
	public Type(int idType, String description) {
		this.idType = idType;
		this.description = description;
	}


	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Type [idType= " + idType + ", description= " + description + " ]";
	}
	
	
}
