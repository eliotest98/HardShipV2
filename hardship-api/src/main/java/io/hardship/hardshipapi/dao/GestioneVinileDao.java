package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Vinile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneVinileDao  extends JpaRepository<Vinile, Integer> {
}
