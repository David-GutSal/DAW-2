package com.dgs.colegio.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgs.colegio.dao.interfaces.IAsignaturasDAO;
import com.dgs.colegio.dtos.AsignaturaDTO;
import com.dgs.colegio.service.interfaces.IAsignaturasService;

@Service
public class AsignaturasServiceImp implements IAsignaturasService {
	
	@Autowired
	IAsignaturasDAO asignaturas;
	
    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException {
        return asignaturas.obtenerTodasAsignaturas();
    }

    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Double tasa,
            int activo) {
        return asignaturas.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activo);
    }

    @Override
    public int insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
            int activo) {
        return asignaturas.insertarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa,
            int activo) {
        return asignaturas.actualizarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int borrarAsignatura(Integer id) {
        return asignaturas.borrarAsignatura(id);
    }

}
