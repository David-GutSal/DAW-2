package dto;

public class MatriculaDTO {
	private String id;
	private String asignatura;
	private String alumno;
	private String fecha;
	private int activo;
	private String tasa;
	
	public MatriculaDTO(String id, String asignatura, String alumno, String fecha, String tasa) {
		super();
		this.id = id;
		this.asignatura = asignatura;
		this.alumno = alumno;
		this.fecha = fecha;
		this.tasa = tasa;
	}

	public MatriculaDTO(String asignatura, String alumno, String fecha, int activo, String tasa) {
		super();
		this.asignatura = asignatura;
		this.alumno = alumno;
		this.fecha = fecha;
		this.activo = activo;
		this.tasa = tasa;
	}

	public MatriculaDTO(String id, String asignatura, String alumno, String fecha, int activo, String tasa) {
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
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getTasa() {
		return tasa;
	}
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}

	@Override
	public String toString() {
		return "MatriculaDTO [id=" + id + ", asignatura=" + asignatura + ", alumno=" + alumno + ", fecha=" + fecha
				+ ", activo=" + activo + ", tasa=" + tasa + "]";
	}
	
	
	
}
