package org.Challenge.Repositories;

import org.Challenge.Entities.BitacoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository extends JpaRepository<BitacoraEntity, Integer> {
}
