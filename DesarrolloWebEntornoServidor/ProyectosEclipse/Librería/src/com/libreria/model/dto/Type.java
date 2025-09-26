package com.libreria.model.dto;


public class Type{
	private String idType;
	private String description;
	
	public Type(String searchIdType, String description) {
		this.idType = searchIdType;
		this.description = description;
	}


	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
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
