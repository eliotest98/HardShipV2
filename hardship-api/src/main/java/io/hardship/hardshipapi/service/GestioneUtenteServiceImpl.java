package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneUtenteDao;
import io.hardship.hardshipapi.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GestioneUtenteServiceImpl implements GestioneUtenteService {
    @Autowired
     GestioneUtenteDao gestioneUtenteDao;

    public int registraCliente(Cliente cliente) {
        return gestioneUtenteDao.insertCliente(cliente.getNome(),cliente.getCognome(),cliente.getDataNascita(),cliente.getUsername(),cliente.getPassword(),cliente.getCodiceFiscale(),cliente.getEmail(),cliente.getCodiceFiscale(),cliente.getDataNascita());
    }

    @Override
    public Cliente loginCliente(String username, String password) {
        return gestioneUtenteDao.loginCliente(username,password);
    }

}
