package org.doomtech.kameorder.Venta.repository;

import org.doomtech.kameorder.Venta.model.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRespository extends CrudRepository<Venta, Integer> {
}
