package com.dgs.colegio.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculaciones")
public class MatriculacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_asignatura")
	private AsignaturaEntity asignatura;
	
	
	@ManyToOne
	@JoinColumn(name = "id_alumno")
	private AlumnoEntity alumnos;
	
	
	@Column
	@JoinColumn(name = "fecha")
	private String fecha;
	
	
	@Column
	@JoinColumn(name = "activo")
	private Integer activo;
	
	@OneToOne (mappedBy = "matricula", cascade = CascadeType.REMOVE)
	private CajaEntity caja;


	
	
	public MatriculacionEntity(Integer id, AsignaturaEntity asignatura, AlumnoEntity alumnos, String fecha,
			Integer activo, CajaEntity caja) {
		super();
		this.id = id;
		this.asignatura = asignatura;
		this.alumnos = alumnos;
		this.fecha = fecha;
		this.activo = activo;
		this.caja = caja;
	}

	public MatriculacionEntity() {
		super();
	}


	public MatriculacionEntity(Integer id, AsignaturaEntity asignatura, AlumnoEntity alumnos, String fecha,
			Integer activo) {
		super();
		this.id = id;
		this.asignatura = asignatura;
		this.alumnos = alumnos;
		this.fecha = fecha;
		this.activo = activo;
	}



	public CajaEntity getCaja() {
		return caja;
	}

	public void setCaja(CajaEntity caja) {
		this.caja = caja;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public AsignaturaEntity getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(AsignaturaEntity asignatura) {
		this.asignatura = asignatura;
	}


	public AlumnoEntity getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(AlumnoEntity alumnos) {
		this.alumnos = alumnos;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Integer getActivo() {
		return activo;
	}


	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	
}
