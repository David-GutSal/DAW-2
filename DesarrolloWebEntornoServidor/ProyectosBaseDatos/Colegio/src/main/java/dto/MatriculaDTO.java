package dto;

public class MatriculaDTO {
	private String id;
	private String asignatura;
	private String alumno;
	private String fecha;
	private String activo;
	private String tasa;
	
	public MatriculaDTO(String asignatura, String alumno, String fecha, String activo, String tasa) {
		super();
		this.asignatura = asignatura;
		this.alumno = alumno;
		this.fecha = fecha;
		this.activo = activo;
		this.tasa = tasa;
	}

	public MatriculaDTO(String id, String asignatura, String alumno, String fecha, String activo, String tasa) {
		super();
		this.id = id;
		this.asignatura = asignatura;
		this.alumno = alumno;
		this.fecha = fecha;
		this.activo = activo;
		this.tasa = tasa;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getTasa() {
		return tasa;
	}
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}
	
}
