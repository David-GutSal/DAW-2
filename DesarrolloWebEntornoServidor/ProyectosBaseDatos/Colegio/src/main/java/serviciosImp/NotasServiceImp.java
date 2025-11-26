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
	public ArrayList<NotasDTO> obtenerNotasFiltradas(String id, String nombre, String idasignatura, String nota, String fecha, String activo) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.obtenerNotasFiltradas(id, nombre, idasignatura, nota, fecha, activo);
	}

	@Override
	public int insertarNota(String id, String id_alumno, String id_asignatura, String nota,  String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.insertarNota(id, id_alumno, id_asignatura, nota, fecha);
	}

	@Override
	public int actualizarNota(String id, String id_alumno, String id_asignatura, String nota,  String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.actualizarNota(id, id_alumno, id_asignatura, nota, fecha);
	}

	@Override
	public int borrarNota(String id) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.borrarNota(id);
	}

}
