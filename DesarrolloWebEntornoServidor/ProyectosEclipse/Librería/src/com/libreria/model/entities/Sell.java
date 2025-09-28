package com.libreria.model.entities;

import java.util.Date;

public class Sell{
	private int idSell;
	private String client;
	private Date date;
	private int idEmploye;
	private String idPublication;
	private int amount;
	private double price;
	private double dcto;
	private double tax;
	public Sell(int idSell, String client, Date date, int idEmploye, String idPublication, int amount, double price,
			double dcto, double tax) {
		super();
		this.idSell = idSell;
		this.client = client;
		this.date = date;
		this.idEmploye = idEmploye;
		this.idPublication = idPublication;
		this.amount = amount;
		this.price = price;
		this.dcto = dcto;
		this.tax = tax;
	}
	public int getIdSell() {
		return idSell;
	}
	public void setIdSell(int idSell) {
		this.idSell = idSell;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	public String getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(String idPublication) {
		this.idPublication = idPublication;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDcto() {
		return dcto;
	}
	public void setDcto(double dcto) {
		this.dcto = dcto;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	@Override
	public String toString() {
		return "Sell [idSell=" + idSell + ", client=" + client + ", date=" + date + ", idEmploye=" + idEmploye
				+ ", idPublication=" + idPublication + ", amount=" + amount + ", price=" + price + ", dcto=" + dcto
				+ ", tax=" + tax + "]";
	}
	
	
}
