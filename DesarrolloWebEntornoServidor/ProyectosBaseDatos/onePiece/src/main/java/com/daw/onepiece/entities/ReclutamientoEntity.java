package com.daw.onepiece.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reclutamiento")
public class ReclutamientoEntity {
    @Id
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private PirataEntity pirata;
    
    @ManyToOne
    @JoinColumn(name = "tripulacion_id")
    private TripulacionEntity tripulacion;
    
    @Column(name = "rol")
    private String rol;
    
    @Column(name = "esMiembroActual")
    private boolean esMiembroActual;
    
    public ReclutamientoEntity() {
    }
    
    public ReclutamientoEntity(int id, PirataEntity pirata, TripulacionEntity tripulacion, 
                               String rol, boolean esMiembroActual) {
        this.id = id;
        this.pirata = pirata;
        this.tripulacion = tripulacion;
        this.rol = rol;
        this.esMiembroActual = esMiembroActual;
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

	public TripulacionEntity getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(TripulacionEntity tripulacion) {
		this.tripulacion = tripulacion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isEsMiembroActual() {
		return esMiembroActual;
	}

	public void setEsMiembroActual(boolean esMiembroActual) {
		this.esMiembroActual = esMiembroActual;
	}
    
    
}