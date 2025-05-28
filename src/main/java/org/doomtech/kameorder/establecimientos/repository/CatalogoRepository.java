package org.doomtech.kameorder.establecimientos.repository;

import org.doomtech.kameorder.establecimientos.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
}