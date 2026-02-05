package com.daw.onepiece.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.entities.ReclutamientoEntity;

@Repository
public interface ReclutamientoRepository extends CrudRepository<ReclutamientoEntity, Integer> {
	@Query("SELECT r FROM ReclutamientoEntity r WHERE r.pirata.id = :pirata_id AND r.tripulacion.id = :tripulacion_id")
	
	ReclutamientoEntity buscarMiembro(
			@Param("pirata_id") Integer idPirata, 
			@Param("tripulacion_id") Integer idTripulacion);

}
