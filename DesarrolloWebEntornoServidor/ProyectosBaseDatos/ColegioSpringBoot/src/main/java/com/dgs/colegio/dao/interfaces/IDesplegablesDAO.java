package com.dgs.colegio.dao.interfaces;

import java.util.ArrayList;

import com.dgs.colegio.dtos.DesplegableDTO;

public interface IDesplegablesDAO {
	ArrayList<DesplegableDTO> desplegableMunicipios();

	ArrayList<DesplegableDTO> desplegableAlumnos();

	ArrayList<DesplegableDTO> desplegableAsignaturas();
}
