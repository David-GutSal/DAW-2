package com.daw.onepiece.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Isla")
public class IslaEntity {
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    public IslaEntity() {
    }
    
    public IslaEntity(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    
    
}