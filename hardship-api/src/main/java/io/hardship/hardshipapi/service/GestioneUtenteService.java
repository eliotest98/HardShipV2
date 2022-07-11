package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.entity.Cliente;


public interface GestioneUtenteService {


     int registraCliente(Cliente cliente);

     Cliente loginCliente(String username, String password);
}