package org.doomtech.kameorder.empleado.repository;

import org.doomtech.kameorder.empleado.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>, JpaSpecificationExecutor<Empleado> {
}