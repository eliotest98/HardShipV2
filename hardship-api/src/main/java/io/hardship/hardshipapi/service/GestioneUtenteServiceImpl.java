package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneUtenteDao;
import io.hardship.hardshipapi.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GestioneUtenteServiceImpl implements GestioneUtenteService {
    @Autowired
     GestioneUtenteDao gestioneUtenteDao;

    public Cliente registraCliente(Cliente cliente) {
        Cliente clienteRegistrato = gestioneUtenteDao.save(cliente);
        if (clienteRegistrato == null) {
            // throw new UsernameNotFoundException("User not found");
        }
        return clienteRegistrato;
    }

}
