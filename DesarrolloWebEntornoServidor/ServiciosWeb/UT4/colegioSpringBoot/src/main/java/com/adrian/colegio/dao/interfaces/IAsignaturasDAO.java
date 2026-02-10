package com.adrian.colegio.dao.interfaces;

import java.util.ArrayList;
import java.util.Optional;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.entities.AsignaturaEntity;

public interface IAsignaturasDAO {

    ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Double tasa,
			Integer activo);

    int insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
			Integer activo);

    int actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
			Integer activo);

    int borrarAsignatura(Integer id);

    Optional<AsignaturaEntity> obtenerAsignaturaPorId(Integer id);
}
    
