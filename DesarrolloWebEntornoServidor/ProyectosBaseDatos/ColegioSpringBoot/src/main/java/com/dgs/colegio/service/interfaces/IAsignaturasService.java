package com.dgs.colegio.service.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dgs.colegio.dtos.AsignaturaDTO;


public interface IAsignaturasService {
    public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException;

    public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Double tasa,
            int activo);

    public int insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
            int activo);

    public int actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
            int activo);

    public int borrarAsignatura(Integer id);
}
