package org.doomtech.kameorder.establecimientos.repository;

import org.doomtech.kameorder.establecimientos.model.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Integer> {
}