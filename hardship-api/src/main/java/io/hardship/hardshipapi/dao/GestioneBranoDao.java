package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Artista;
import io.hardship.hardshipapi.entity.Brano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneBranoDao  extends JpaRepository<Brano, Integer> {

    /*@Modifying
    @Query(value= "INSERT INTO brano(Titolo,Anno,Durata,ID_album,ID_artista) VALUES (null,:Titolo,:Anno,:Durata,:ID_album,:ID_artista)", nativeQuery = true)
    Brano insertAlbum(@Param("Titolo") String titolo,@Param("Anno") String anno,@Param("Durata") String durata,@Param("ID_album") int ID_album,@Param("ID_artista") int ID_artista);
    */
}
