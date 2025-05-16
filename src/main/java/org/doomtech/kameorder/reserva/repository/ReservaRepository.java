package org.doomtech.kameorder.reserva.repository;

import org.doomtech.kameorder.reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository  extends JpaRepository<Reserva, Integer> {


}
