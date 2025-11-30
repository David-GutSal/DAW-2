package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.INotasDAO;
import daoImp.NotasDAOImpl;
import dto.NotasDTO;
import servicios.INotasService;

public class NotasServiceImp implements INotasService{
	@Override
	public ArrayList<NotasDTO> obtenerNotas() throws SQLException {
		INotasDAO notas = new NotasDAOImpl();
		return notas.obtenerTodasNotas();
	}

	@Override
	public ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String nombre, String asignatura, String nota, String fecha, String activo) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.obtenerNotasFiltradas(id, nombre, asignatura, nota, fecha, activo);
	}

	@Override
	public int insertarNota(String alumno, String asignatura, String nota,  String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.insertarNota(alumno, asignatura, nota, fecha);
	}

	@Override
	public ArrayList<NotasDTO> obtenerNotasFiltradas(String nombre, String asignatura, String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.obtenerNotasFiltradas(nombre, asignatura, fecha);
	}

	@Override
	public int actualizarNotas(String id, String nombre, String asignatura, String nota, String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.actualizarNota(id, nombre, asignatura, nota, fecha);
	}

	@Override
	public int borrarNota(String id, String asignatura, String nota, String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.borrarNota(id, asignatura, nota, fecha);
	}

}
