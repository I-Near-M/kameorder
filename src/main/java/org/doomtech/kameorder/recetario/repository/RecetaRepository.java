package org.doomtech.kameorder.recetario.repository;

import org.doomtech.kameorder.recetario.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer> {
}