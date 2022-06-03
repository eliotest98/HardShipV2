package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Etichetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneEtichettaDao extends JpaRepository<Etichetta, Integer> {

    @Modifying
    @Query(value = "INSERT INTO etichetta (Nome) VALUES (:nome)",  nativeQuery = true)
    Etichetta insertEtichetta(@Param("nome") String nome);
}
