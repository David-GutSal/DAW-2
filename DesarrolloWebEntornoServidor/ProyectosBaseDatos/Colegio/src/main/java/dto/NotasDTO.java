package dto;

public class NotasDTO {
	private String id;
	private String id_alumno;
	private String id_asignatura;
	private int nota;
	private String fecha;
	
	public NotasDTO(String id, String id_alumno, String id_asignatura, int nota, String fecha) {
		super();
		this.id = id;
		this.id_alumno = id_alumno;
		this.id_asignatura = id_asignatura;
		this.nota = nota;
		this.fecha = fecha;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(String id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(String id_asignatura) {
		this.id_asignatura = id_asignatura;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}