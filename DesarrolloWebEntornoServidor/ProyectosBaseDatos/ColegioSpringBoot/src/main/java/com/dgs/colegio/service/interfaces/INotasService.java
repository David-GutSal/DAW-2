package com.dgs.colegio.service.interfaces;

import java.sql.SQLException;

import java.util.ArrayList;

import com.dgs.colegio.dtos.NotaDTO;


public interface INotasService {
    public ArrayList<NotaDTO> obtenerNotas() throws SQLException;

    public int insertarNota(Integer alumno, Integer asignatura, String nota, String fecha);

    public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

    public int borrarNota(Integer id);

	public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String nombreAsignatura,
            String nota, String fecha, Integer activo);

	public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(Integer idAlumno, String nombreAlumno, String nombreAsignatura,
            String nota, Integer activo);
}
