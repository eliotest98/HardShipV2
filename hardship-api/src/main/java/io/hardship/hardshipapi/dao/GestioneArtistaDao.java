package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GestioneArtistaDao extends JpaRepository<Artista, Integer> {

    /*@Transactional
    @Modifying
    @Query(value= "INSERT INTO artista(Nome) VALUES (:nome)", nativeQuery = true)
    int insertArtista(@Param("nome") String nome);*/
}
