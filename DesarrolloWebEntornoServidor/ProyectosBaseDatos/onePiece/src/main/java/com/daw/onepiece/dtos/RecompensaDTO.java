package com.daw.onepiece.dtos;

public class RecompensaDTO {
	private Integer id;
	private Integer idPirata;
	private String nombrePirata;
	private String tripulacion;
	private Double cantidad;
	private Integer estaVigente;

	public RecompensaDTO(Integer id, Integer idPirata, String nombrePirata, String tripulacion, Double cantidad,
			Integer estaVigente) {
		this.id = id;
		this.idPirata = idPirata;
		this.nombrePirata = nombrePirata;
		this.tripulacion = tripulacion;
		this.cantidad = cantidad;
		this.estaVigente = estaVigente;
	}
	
	

	public Integer getId() {
		return id;
	}

	public Integer getIdPirata() {
		return idPirata;
	}

	public String getNombrePirata() {
		return nombrePirata;
	}

	public String getTripulacion() {
		return tripulacion;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public Integer getEstaVigente() {
		return estaVigente;
	}
}
