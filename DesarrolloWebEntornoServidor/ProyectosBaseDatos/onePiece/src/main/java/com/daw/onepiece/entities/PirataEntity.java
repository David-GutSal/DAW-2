package com.daw.onepiece.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Pirata`")
public class PirataEntity {
    @Id
    @Column(name = "`id`")
    private int id;
    
    @Column(name = "`nombre`")
    private String nombre;
    
    @Column(name = "`frutaDelDiablo`")
    private String frutaDelDiablo;
    
    @Column(name = "`fechaNacimiento`")
    private LocalDate fechaNacimiento;
    
    @Column(name = "`estaActivo`")
    private boolean estaActivo;
    
    @ManyToOne
    @JoinColumn(name = "`isla_id`")
    private IslaEntity isla;
    
    @OneToMany(mappedBy = "pirata")
    private List<ReclutamientoEntity> reclutamientos;
    
    public PirataEntity() {
    }
    
    public PirataEntity(int id, String nombre, String frutaDelDiablo, LocalDate fechaNacimiento, 
                       boolean estaActivo, IslaEntity isla) {
        this.id = id;
        this.nombre = nombre;
        this.frutaDelDiablo = frutaDelDiablo;
        this.fechaNacimiento = fechaNacimiento;
        this.estaActivo = estaActivo;
        this.isla = isla;
    }

	

	public PirataEntity(String nombre, String frutaDelDiablo, LocalDate fechaNacimiento, IslaEntity isla, boolean estaActivo) {
		super();
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fechaNacimiento = fechaNacimiento;
		this.estaActivo = estaActivo;
		this.isla = isla;
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

	public String getFrutaDelDiablo() {
		return frutaDelDiablo;
	}

	public void setFrutaDelDiablo(String frutaDelDiablo) {
		this.frutaDelDiablo = frutaDelDiablo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public IslaEntity getIsla() {
		return isla;
	}

	public void setIsla(IslaEntity isla) {
		this.isla = isla;
	}

	public List<ReclutamientoEntity> getReclutamientos() {
		return reclutamientos;
	}

	public void setReclutamientos(List<ReclutamientoEntity> reclutamientos) {
		this.reclutamientos = reclutamientos;
	}
    
    
}