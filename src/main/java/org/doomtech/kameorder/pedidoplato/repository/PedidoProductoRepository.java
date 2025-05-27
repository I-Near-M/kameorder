package org.doomtech.kameorder.pedidoplato.repository;

import org.doomtech.kameorder.pedidoplato.model.PedidoProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PedidoProductoRepository extends CrudRepository<PedidoProducto,Integer> {
}
