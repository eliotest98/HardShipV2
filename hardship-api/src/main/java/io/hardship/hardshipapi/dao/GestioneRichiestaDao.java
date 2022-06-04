package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Richiesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneRichiestaDao extends JpaRepository<Richiesta, Integer> {
}
