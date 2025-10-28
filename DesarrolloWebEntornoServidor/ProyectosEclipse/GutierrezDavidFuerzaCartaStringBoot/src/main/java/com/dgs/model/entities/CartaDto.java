package com.dgs.model.entities;

public class CartaDto {
	private int cost;
	private int damage;
	private int life;
	
	public CartaDto(int cost, int damage, int life) {
		super();
		this.cost = cost;
		this.damage = damage;
		this.life = life;
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
