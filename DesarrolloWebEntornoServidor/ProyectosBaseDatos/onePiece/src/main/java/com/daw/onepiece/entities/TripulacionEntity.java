package com.daw.onepiece.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tripulacion")
public class TripulacionEntity {
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "barco")
    private String barco;
    
    @Column(name = "estaActiva")
    private Boolean activo;
    
    public TripulacionEntity() {}

	public TripulacionEntity(int id, String nombre, String barco, Boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.barco = barco;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBarco() {
		return barco;
	}

	public void setBarco(String barco) {
		this.barco = barco;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
    
}
