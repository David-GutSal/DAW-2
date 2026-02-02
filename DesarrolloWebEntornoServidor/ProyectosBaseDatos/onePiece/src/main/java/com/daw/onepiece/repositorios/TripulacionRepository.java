package com.daw.onepiece.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.entities.TripulacionEntity;

@Repository
public interface TripulacionRepository extends CrudRepository<TripulacionEntity, Integer>{

	@Query("SELECT new com.daw.onepiece.dtos.TripulacionDTO("
		    + "t.id, "
		    + "t.nombre, "
		    + "t.barco, "
		    + "CAST((SELECT COUNT(r) FROM ReclutamientoEntity r WHERE r.tripulacion = t AND r.esMiembroActual = true) AS int), "
		    + "t.activo) "
		    + "FROM TripulacionEntity t "
		    + "WHERE (CASE WHEN :id IS NULL THEN TRUE ELSE CAST(t.id AS string) LIKE CONCAT('%', :id, '%')END) "
		    + "AND (:nombre IS NULL OR t.nombre LIKE CONCAT('%', :nombre, '%')) "
		    + "AND (:barco IS NULL OR t.barco LIKE CONCAT('%', :barco, '%')) "
		    + "AND (:activo IS NULL OR t.activo = :activo)")
	
	ArrayList<TripulacionDTO> obtenerTripulacionesPorFiltro(
			@Param("id") String id, 
			@Param("nombre") String nombre, 
			@Param("barco") String barco, 
			@Param("activo") Boolean act
			);

}
