package org.doomtech.kameorder.pedido.repository;

import org.doomtech.kameorder.pedido.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoController extends CrudRepository<Pedido, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
