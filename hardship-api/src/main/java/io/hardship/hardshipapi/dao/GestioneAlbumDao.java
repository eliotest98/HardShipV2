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


    @Query(value = "SELECT * FROM Album a WHERE a.ID LIKE %:pid%", nativeQuery = true)
    Album findAlbumByPidLike(@Param("pid") Integer pid);


}
