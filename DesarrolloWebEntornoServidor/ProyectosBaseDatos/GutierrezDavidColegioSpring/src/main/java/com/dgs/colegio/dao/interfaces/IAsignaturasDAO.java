package com.dgs.colegio.dao.interfaces;

import java.util.ArrayList;

import com.dgs.colegio.dtos.AsignaturaDTO;


public interface IAsignaturasDAO {

    ArrayList<AsignaturaDTO> obtenerTodasAsignaturas();

    ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Double tasa,
            int activo);

    int insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
            int activo);

    int actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
            int activo);

    double obtenerTasaAsignatura(Integer idAsignatura);

	int borrarAsignatura(Integer id);

}
