package com.daw.onepiece.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PirataDTO {
	private int id;
	private String nombre;
	private String fruta;
	private String tripulacion;
	private String fechaNacimiento;
	private String islaOrigen;
	private boolean activo;

	public PirataDTO() {
	}

	public PirataDTO(int id, String nombre, String fruta, String tripulacion, LocalDate fechaNacimiento,
			String islaOrigen, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.fruta = fruta;
		this.tripulacion = tripulacion;
		this.fechaNacimiento = fechaNacimiento != null
				? fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				: "";
		this.islaOrigen = islaOrigen;
		this.activo = activo ? true : false;
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

	public String getFruta() {
		return fruta;
	}

	public void setFruta(String fruta) {
		this.fruta = fruta;
	}

	public String getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(String tripulacion) {
		this.tripulacion = tripulacion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIslaOrigen() {
		return islaOrigen;
	}

	public void setIslaOrigen(String islaOrigen) {
		this.islaOrigen = islaOrigen;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
