package com.dgs.castronegro.model.dto;

public class RolDTO {
	private String rol;
	private String mensaje;
	public RolDTO(String rol, String mensaje) {
		super();
		this.rol = rol;
		this.mensaje = mensaje;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
