package com.p02.model.dto;

public class ClienteDto {
	private String nombre;
	private String telefono;

	public ClienteDto(String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "ClienteDto [nombre=" + nombre + ", telefono=" + telefono + "]";
	}

}
