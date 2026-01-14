package com.dgs.colegio.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgs.colegio.dao.interfaces.INotasDAO;
import com.dgs.colegio.dtos.NotaDTO;
import com.dgs.colegio.service.interfaces.INotasService;

@Service
public class NotasServiceImp implements INotasService {
	@Autowired
	INotasDAO notas;
	
    @Override
    public ArrayList<NotaDTO> obtenerNotas() throws SQLException {

        return notas.obtenerTodasNotas();
    }

    @Override
    public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idAlumno, String nombreAlumno, String asignatura,
            Integer nota, String fecha, int activo) {
        return notas.obtenerNotasPorFiltros(idAlumno, nombreAlumno, asignatura, nota, fecha, activo);
    }

    @Override
    public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(Integer idAlumno, String nombreAlumno, String asignatura,
            Integer nota, int activo) {
        return notas.obtenerNotasPorFiltrosSinFecha(idAlumno, nombreAlumno, asignatura, nota, activo);
    }

    @Override
    public int insertarNota(Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
        return notas.insertarNota(idAlumno, idAsignatura, nota, fecha);
    }

    @Override
    public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
        return notas.actualizarNota(id, idAlumno, idAsignatura, nota, fecha);
    }

    @Override
    public int borrarNota(Integer id) {
        return notas.borrarNota(id);
    }

}
