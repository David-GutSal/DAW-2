package com.fcartas.model.entities;

public class Carta {
	private String name;
	private int cost;
	private int damage;
	private int life;
	public Carta(String name, int cost, int damage, int life) {
		super();
		this.name = name;
		this.cost = cost;
		this.damage = damage;
		this.life = life;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
}
