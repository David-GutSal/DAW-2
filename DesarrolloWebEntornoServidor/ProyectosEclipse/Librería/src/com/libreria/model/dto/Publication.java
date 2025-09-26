package com.libreria.model.dto;

public class Publication {
	private String idpublication;
	private String title;
	private String author;
	private int edition;
	private double price;
	private int stock;
	private String idType;
	public Publication(String idpublication, String title, String author, int edition, double price, int stock,
			String idType) {
		super();
		this.idpublication = idpublication;
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.price = price;
		this.stock = stock;
		this.idType = idType;
	}
	public String getIdpublication() {
		return idpublication;
	}
	public void setIdpublication(String idpublication) {
		this.idpublication = idpublication;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	@Override
	public String toString() {
		return "Publication [idpublication= " + idpublication + ", title= " + title + ", author= " + author + ", edition= "
				+ edition + ", price= " + price + ", stock= " + stock + ", idType= " + idType + "]";
	}
	
	
}
