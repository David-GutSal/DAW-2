package dto;

public class NotasDTO {
	private String id;
	private String alumno;
	private String asignatura;
	private String nota;
	private String fecha;
	
	public NotasDTO(String id, String alumno, String asignatura, String nota, String fecha) {
		super();
		this.id = id;
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.nota = nota;
		this.fecha = fecha;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getalumno() {
		return alumno;
	}
	public void setalumno(String alumno) {
		this.alumno = alumno;
	}
	public String getasignatura() {
		return asignatura;
	}
	public void setasignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}