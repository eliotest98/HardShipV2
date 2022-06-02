/*package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class GestioneUtenteDaoTest {

    @Autowired
    private GestioneUtenteDao gestioneUtenteDao;

    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    public void registerCliente(){
        String nome = "Pippo";
        String cognome = "Pluto";
        String user = "allor";

        String cf = "asdped120jdla";
        String data = "20-10-95";
        String email = "test@test.it";
        String password = "hola";

        Cliente clienteDaRegistrare = new Cliente(nome, cognome, data, user, password, cf, email);

        Cliente clienteRegistrato = gestioneUtenteDao.save(clienteDaRegistrare);

        Cliente clienteEsistente = testEntityManager.find(Cliente.class,  clienteRegistrato.getId());

       // assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}*/

