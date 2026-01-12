package com.dgs.colegio.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dgs.colegio.dtos.AsignaturaDTO;
import com.dgs.colegio.entities.AsignaturaEntity;

@Repository
public interface AsignaturaRepository extends CrudRepository<AsignaturaEntity, Integer>{
	@Query("select new com.dgs.colegio.dtos.AsignaturaDTO (a.id,a.nombre,a.curso,a.tasa,a.activo) "
			+ "FROM com.dgs.colegio.entities.AsignaturaEntity a "
			+ "WHERE (:id IS NULL OR CAST(a.id AS string) LIKE CONCAT('%', :id, '%'))  "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND (:curso IS NULL OR CAST(a.curso AS string) LIKE CONCAT('%', :curso, '%')) "
			+ "AND a.tasa >= :tasa "
			+ "AND a.activo = :activo")
	
	ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(
		@Param("id") Integer id, 
		@Param("nombre") String nombre,
		@Param("curso") Integer curso, 
		@Param("tasa") Double tasa,
		@Param("activo") Integer activo);
}
