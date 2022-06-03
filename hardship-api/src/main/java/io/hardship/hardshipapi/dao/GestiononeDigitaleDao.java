package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Artista;
import io.hardship.hardshipapi.entity.Digitale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GestiononeDigitaleDao   extends JpaRepository<Digitale, Integer> {

    @Modifying
    @Query(value= "INSERT INTO digitale(Prezzo,numero_Copie,ID_album) VALUES (null,:Prezzo,:numero_Copie,:ID_album)", nativeQuery = true)
    Digitale insertDigitale(@Param("Prezzo") String prezzo,@Param("numero_Copie") int numero_Copie,@Param("ID_album") int ID_album);
}
