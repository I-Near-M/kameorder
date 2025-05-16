package org.doomtech.kameorder.pedidoplato.repository;

import org.doomtech.kameorder.pedidoplato.model.PedidoPlato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface  PedidoPlatoRepository extends CrudRepository<PedidoPlato,Integer> {
}
