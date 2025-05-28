package org.doomtech.kameorder.insumo.repository;

import org.doomtech.kameorder.insumo.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer> {
}