package com.daw.onepiece.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.entities.ReclutamientoEntity;
import com.daw.onepiece.entities.TripulacionEntity;

@Repository
@Transactional
public interface ReclutamientoRepository extends CrudRepository<ReclutamientoEntity, Integer> {
	
	@Query("SELECT r FROM ReclutamientoEntity r WHERE r.pirata.id = :pirata_id AND r.tripulacion.id = :tripulacion_id")
	ReclutamientoEntity buscarMiembro(
			@Param("pirata_id") Integer idPirata, 
			@Param("tripulacion_id") Integer idTripulacion);

	
	@Query("SELECT r FROM ReclutamientoEntity r WHERE r.pirata = :pirata AND r.tripulacion = :tripulacion")
	Optional<ReclutamientoEntity> findByPirataAndTripulacion(
			@Param("pirata") PirataEntity pirata, 
			@Param("tripulacion")TripulacionEntity tripulacion);

}
