package com.adrian.colegio.dao.interfaces;

import java.util.ArrayList;
import java.util.Optional;

import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.entities.MatriculacionEntity;

public interface IMatriculacionesDAO {
    ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
            String fecha, Integer activo);

    int insertarMatriculacion(Integer idAlumno, Integer idAsignatura, String fecha, Double tasa);

    int actualizarMatriculacion(Integer id, Integer idAlumno, Integer idAsignatura, String fecha, Double tasa);

    int borrarMatriculacion(Integer id);

	Optional<MatriculacionEntity> obtenerMatriculacionPorId(Integer id);
}
