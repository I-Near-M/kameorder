package org.doomtech.kameorder.plato.repository;

import org.doomtech.kameorder.plato.model.Plato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends CrudRepository<Plato, Integer> {
}
