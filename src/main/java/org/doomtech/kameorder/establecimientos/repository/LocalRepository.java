package org.doomtech.kameorder.establecimientos.repository;

import org.doomtech.kameorder.establecimientos.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {
}