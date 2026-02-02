package com.daw.onepiece.dtos;

public class TripulacionDTO {
	private int id;
	private String nombre;
	private String barco;
	private int numeroMiembros;
	private Boolean estaActiva;
	
	public TripulacionDTO(int id, String nombre, String barco, int numeroMiembros, Boolean estaActiva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.barco = barco;
		this.numeroMiembros = numeroMiembros;
		this.estaActiva = estaActiva;
	}

	public TripulacionDTO(int id, String nombre, String barco, Boolean estaActiva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.barco = barco;
		this.estaActiva = estaActiva;
	}
	
	public TripulacionDTO() {
	}



	public int getNumeroMiembros() {
		return numeroMiembros;
	}

	public void setNumeroMiembros(int numeroMiembros) {
		this.numeroMiembros = numeroMiembros;
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

	public Boolean getEstaActiva() {
		return estaActiva;
	}

	public void setEstaActiva(Boolean estaActiva) {
		this.estaActiva = estaActiva;
	}
	
	
}
