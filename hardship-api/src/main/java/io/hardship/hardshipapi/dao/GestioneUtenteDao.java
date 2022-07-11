package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface GestioneUtenteDao extends JpaRepository<Cliente, Long> {

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO Cliente(ID,Nome,Cognome,DataNascita,Username,Password,CodiceFiscale,Email,codice_fiscale,data_nascita) VALUES (null,:Nome,:Cognome,:DataNascita,:Username,:Password,:CodiceFiscale,:Email,:codice_fiscale,:data_nascita)", nativeQuery = true)
    int insertCliente(@Param("Nome") String nome,@Param("Cognome") String cognome,@Param("DataNascita") String dataNascita,@Param("Username") String user,@Param("Password") String pass,@Param("CodiceFiscale") String codiceFiscale,@Param("Email") String email,@Param("codice_fiscale") String codice_fiscale,@Param("data_nascita") String data_nascita);

    @Query(value = "SELECT * FROM Cliente WHERE Username=:user AND Password=:pass",nativeQuery = true)
    Cliente loginCliente(@Param("user") String user,@Param("pass") String pass);

}
