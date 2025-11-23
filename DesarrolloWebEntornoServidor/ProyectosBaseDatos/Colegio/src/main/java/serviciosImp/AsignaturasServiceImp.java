package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IAsignaturasDAO;
import daoImp.AsignaturasDAOImpl;
import dto.AsignaturaDTO;
import servicios.IAsignaturasService;

public class AsignaturasServiceImp implements IAsignaturasService{
	
	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		
		return asignaturas.obtenerTodosAsignaturas();
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorIdNombreCursoTasa(String id, String nombre, String curso, double tasa,  int activo) {
		IAsignaturasDAO asignatura = new AsignaturasDAOImpl();
		return asignatura.obtenerAsignaturasPorIdNombreCursoTasa(id, nombre, curso,  tasa, activo);
	}

	@Override
	public int insertarAsignatura(String id, String nombre, String curso, double tasa,  int activo) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.insertarAsignatura(id, nombre, curso, tasa, activo);
	}

	@Override
	public int actualizarAsignatura(String id, String nombre, String curso, double tasa,  int activo) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.actualizarAsignatura(id, nombre, curso, tasa, activo);
	}

	@Override
	public int borrarAsignatura(String id) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.borrarAsignatura(id);
	}

}
