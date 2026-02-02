package com.daw.onepiece.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.entities.ReclutamientoEntity;

@Repository
public interface ReclutamientoRepository extends CrudRepository<ReclutamientoEntity, Integer> {

}
