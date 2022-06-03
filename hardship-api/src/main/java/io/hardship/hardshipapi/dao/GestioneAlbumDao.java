package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.Artista;
import io.hardship.hardshipapi.entity.Digitale;
import io.hardship.hardshipapi.entity.Etichetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneAlbumDao extends JpaRepository<Album, Integer> {


    @Query("SELECT * FROM Album a WHERE a.ID LIKE %:pid%")
    Album findAlbumByPidLike(@Param("pid") Integer pid);

    @Query("INSERT IGNORE INTO artista (Nome) VALUES (:nome)")
    Artista insertIntoArtista(@Param("nome") String nome);

    @Query("INSERT IGNORE INTO etichetta (Nome) VALUES (:nome);")
    Etichetta insertIntoEtichetta(@Param("nome") String nome);

    @Query("insert into digitale VALUES(null,?,?,?)")
    Digitale insertIntoDigitale();


}
