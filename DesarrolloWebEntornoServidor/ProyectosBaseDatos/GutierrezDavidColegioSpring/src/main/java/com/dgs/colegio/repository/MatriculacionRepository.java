package com.dgs.colegio.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dgs.colegio.dtos.MatriculacionDTO;
import com.dgs.colegio.entities.MatriculacionEntity;

public interface MatriculacionRepository extends CrudRepository<MatriculacionEntity, Integer> {

	@Query("SELECT new com.dgs.colegio.dtos.MatriculacionDTO("
			+ "m.id, "
            + "a.nombre, "
            + "al.nombre, "
            + "m.fecha, "
            + "CAST(m.activo AS int), "  
            + "COALESCE(c.importe, 0.0)) "  
            + "FROM MatriculacionEntity m "
            + "JOIN m.asignatura a "  
            + "JOIN m.alumnos al " 
            + "LEFT JOIN m.caja c "   
            + "WHERE a.nombre LIKE CONCAT('%', :nombreAsignatura, '%') "
            + "AND al.nombre LIKE CONCAT('%', :nombreAlumno, '%') "
            + "AND m.fecha >= :fecha "
            + "AND m.activo = :activo")

	ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(
            @Param("nombreAsignatura") String nombreAsignatura,
            @Param("nombreAlumno") String nombreAlumno,
            @Param("fecha") String fecha,
            @Param("activo") Integer activo);

	@Query("SELECT new com.dgs.colegio.dtos.MatriculacionDTO("
		+ "m.id, " 
		+ "a.id, " 
		+ "al.id, "
		+ "m.fecha, "
		+ "CAST(m.activo AS int), "  
		+ "COALESCE(c.importe, 0.0)) "  
		+ "FROM MatriculacionEntity m "
		+ "JOIN m.asignatura a "  
		+ "JOIN m.alumnos al " 
		+ "LEFT JOIN m.caja c "   
		+ "WHERE a.nombre LIKE CONCAT('%', :nombreAsignatura, '%') "
		+ "AND al.nombre LIKE CONCAT('%', :nombreAlumno, '%') "
		+ "AND m.fecha >= :fecha "  
		+ "AND m.activo = :activo")

ArrayList<MatriculacionDTO> obtenerMatriculacionesParaId(
		@Param("nombreAsignatura") String asignatura,
		@Param("nombreAlumno") String alumno,
		@Param("fecha") String fecha,
		@Param("activo") Integer i);

	
}


