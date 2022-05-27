package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.entity.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneUtenteService {


    public Cliente registraCliente(Cliente cliente);

}
