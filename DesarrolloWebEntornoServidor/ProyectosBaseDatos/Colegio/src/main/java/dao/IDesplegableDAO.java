package dao;

import java.util.ArrayList;

import dto.AsignaturaDTO;
import dto.DesplegableDTO;

public interface IDesplegableDAO {
	ArrayList<DesplegableDTO> desplegableMunicipios();

	ArrayList<DesplegableDTO> desplegableAsignaturas();

	ArrayList<DesplegableDTO> desplegableAlumnos();
}
