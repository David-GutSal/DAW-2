package com.dgs.colegio.service.interfaces;

import java.sql.SQLException;

import java.util.ArrayList;

import com.dgs.colegio.dtos.NotaDTO;


public interface INotasService {
    public ArrayList<NotaDTO> obtenerNotas() throws SQLException;

    public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura,
            Integer nota, String fecha, int activo);

    public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(Integer idAlumno, String nombreAlumno, String asignatura,
            Integer nota, int activo);

    public int insertarNota(Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

    public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

    public int borrarNota(Integer id);
}
