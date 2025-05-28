package org.doomtech.kameorder.mesa.repository;

import org.doomtech.kameorder.mesa.model.Mesa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends CrudRepository<Mesa, Integer> {
}
