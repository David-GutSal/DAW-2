package serviciosImp;

import java.util.ArrayList;

import dao.IMatriculasDAO;
import daoImp.MatriculasDAOImpl;
import dto.MatriculaDTO;
import servicios.IMatriculaService;

public class MatriculaServiceImp implements IMatriculaService{

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasFiltradas(String asignatura, String alumno, String fecha, String activo, String tasa) {
		IMatriculasDAO matricula = new MatriculasDAOImpl();
		return matricula.obtenerMatriculasFiltradas(asignatura, alumno, fecha, activo, tasa);
	}

}
