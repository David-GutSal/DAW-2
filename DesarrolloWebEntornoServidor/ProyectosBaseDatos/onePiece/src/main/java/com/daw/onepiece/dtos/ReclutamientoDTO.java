package com.daw.onepiece.dtos;

public class ReclutamientoDTO {
	private Integer id;
	private Integer pirata_id;
	private Integer tripulacion_id;
	private String rol;
	private Boolean esMiembroActual;
	
	public ReclutamientoDTO() {
	}
	
	public ReclutamientoDTO(Integer id, Integer pirata_id, Integer tripulacion_id, String rol,
			Boolean esMiembroActual) {
		super();
		this.id = id;
		this.pirata_id = pirata_id;
		this.tripulacion_id = tripulacion_id;
		this.rol = rol;
		this.esMiembroActual = esMiembroActual;
	}
	
	public ReclutamientoDTO(Integer id, Integer pirata_id, Integer tripulacion_id, Boolean esMiembroActual) {
		super();
		this.id = id;
		this.pirata_id = pirata_id;
		this.tripulacion_id = tripulacion_id;
		this.esMiembroActual = esMiembroActual;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPirata_id() {
		return pirata_id;
	}
	public void setPirata_id(Integer pirata_id) {
		this.pirata_id = pirata_id;
	}
	public Integer getTripulacion_id() {
		return tripulacion_id;
	}
	public void setTripulacion_id(Integer tripulacion_id) {
		this.tripulacion_id = tripulacion_id;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Boolean getEsMiembroActual() {
		return esMiembroActual;
	}
	public void setEsMiembroActual(Boolean esMiembroActual) {
		this.esMiembroActual = esMiembroActual;
	}
}
