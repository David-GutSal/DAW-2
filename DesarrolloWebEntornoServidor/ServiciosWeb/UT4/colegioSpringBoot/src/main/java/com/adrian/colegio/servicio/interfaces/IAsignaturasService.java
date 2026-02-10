package com.adrian.colegio.servicio.interfaces;

import java.util.ArrayList;
import java.util.Optional;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.entities.AsignaturaEntity;

public interface IAsignaturasService {
    ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Double tasa,
			Integer activo);

    int insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
			Integer activo);

    int actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
			Integer activo);

    int borrarAsignatura(Integer id);

    Optional<AsignaturaEntity> obtenerAsignaturaPorId(Integer id);
}
