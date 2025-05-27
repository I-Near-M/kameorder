package org.doomtech.kameorder.producto.repository;

import org.doomtech.kameorder.producto.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends CrudRepository<Producto, Integer> {
}
