package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Cd;
import io.hardship.hardshipapi.entity.Vinile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface GestioneCDDao  extends JpaRepository<Cd, Integer> {

    @Modifying
    @Query(value= "INSERT INTO cd(Prezzo,numero_Copie,ID_album) VALUES (null,:Prezzo,:numero_Copie,:ID_album)", nativeQuery = true)
    Cd insertCD(@Param("Prezzo") String prezzo, @Param("numero_Copie") int numero_Copie, @Param("ID_album") int ID_album);
}
