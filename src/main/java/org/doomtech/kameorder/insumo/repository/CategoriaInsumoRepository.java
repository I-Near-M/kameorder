package org.doomtech.kameorder.insumo.repository;

import org.doomtech.kameorder.insumo.model.CategoriaInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaInsumoRepository extends JpaRepository<CategoriaInsumo, Integer> {
}