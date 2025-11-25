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
	public ArrayList<NotasDTO> obtenerNotasFiltradas(String nota,  String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.obtenerNotasFiltradas(nota, fecha);
	}

	@Override
	public int insertarNota(String id, String id_alumno, String id_asignatura, int nota,  String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.insertarNota(id, id_alumno, id_asignatura, nota, fecha);
	}

	@Override
	public int actualizarNota(String id, String id_alumno, String id_asignatura, int nota,  String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.actualizarNota(id, id_alumno, id_asignatura, nota, fecha);
	}

	@Override
	public int borrarNota(String id) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.borrarNota(id);
	}

}
