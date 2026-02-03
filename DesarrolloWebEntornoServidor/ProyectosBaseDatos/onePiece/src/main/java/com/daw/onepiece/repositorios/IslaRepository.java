package com.daw.onepiece.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.entities.IslaEntity;

@Repository
public interface IslaRepository  extends CrudRepository<IslaEntity, Integer>{

}
