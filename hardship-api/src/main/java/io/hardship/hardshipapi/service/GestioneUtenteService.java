package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface GestioneUtenteService {


    public Cliente registraCliente(Cliente cliente);

}
