package com.daw.onepiece.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RecompensaEntity {
    @Id
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private PirataEntity pirata;
    
    @Column(name = "cantidad")
    private Double cantidad;
    
    @Column(name = "estaVigente")
    private Boolean vigente;

	public RecompensaEntity(int id, PirataEntity pirata, Double cantidad, Boolean vigente) {
		super();
		this.id = id;
		this.pirata = pirata;
		this.cantidad = cantidad;
		this.vigente = vigente;
	}
	public RecompensaEntity() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PirataEntity getPirata() {
		return pirata;
	}
	public void setPirata(PirataEntity pirata) {
		this.pirata = pirata;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Boolean getVigente() {
		return vigente;
	}
	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}
    
    
}
