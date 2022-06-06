package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.Artista;
import io.hardship.hardshipapi.entity.Digitale;
import io.hardship.hardshipapi.entity.Etichetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestioneAlbumDao extends JpaRepository<Album, Integer> {

    /*@Modifying
    @Query(value= "INSERT INTO album(Genere,Titolo,Copertina,numero_brani,data,Embed,Dettagli,username_admin,ID_etichetta,ID_artista) VALUES (null,:Genere,:Titolo,:Copertina,:numero_brani,:data,:Embed,:Dettagli,:username_admin,:ID_etichetta,:ID_artista)", nativeQuery = true)
    int insertAlbum(@Param("Genere") String genere,@Param("Titolo") String titolo,@Param("Copertina") String copertina,@Param("numero_brani") int numero_brani,@Param("data") String data,@Param("Embed") String embed,@Param("Dettagli") String dettagli,@Param("username_admin") String username_admin,@Param("ID_etichetta") int ID_etichetta,@Param("ID_artista") int ID_artista);
    */
}
