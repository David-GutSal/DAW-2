package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matriculaciones")
public class MatriculacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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


	public MatriculacionEntity(Integer id, AsignaturaEntity asignatura, AlumnoEntity alumnos, String fecha,
			Integer activo) {
		super();
		this.id = id;
		this.asignatura = asignatura;
		this.alumnos = alumnos;
		this.fecha = fecha;
		this.activo = activo;
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
