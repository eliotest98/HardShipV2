package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneUtenteDao;
import io.hardship.hardshipapi.entity.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GestioneUtenteServiceTest {
    @Mock
    private GestioneUtenteDao gestioneUtenteDao;
    @Autowired
    @InjectMocks
    private GestioneUtenteServiceImpl gestioneUtenteService;
    private Cliente cliente;
    @BeforeEach
    public void setUp() {
        cliente = new Cliente(1, "Pippo", "Pippo", "pippo98", "pippo_98", "pippo@libero.it", "15-02-1965", "PSPLEI09A05T807X");
    }

    @AfterEach
    public void tearDown() {
        cliente = null;
    }

    //Test Case for register a client
    @Test
    void registerClientTest() throws Exception{
        //stubbing
        gestioneUtenteService.registraCliente(cliente);
        verify(gestioneUtenteDao,times(1)).insertCliente(cliente.getNome(),cliente.getCognome(),cliente.getDataNascita(),cliente.getUsername(),cliente.getPassword(),cliente.getCodiceFiscale(),cliente.getEmail(),cliente.getCodiceFiscale(),cliente.getDataNascita());
    }

    //Test Case for login client
    @Test
    void loginCliente() throws Exception {
        gestioneUtenteService.loginCliente(cliente.getUsername(),cliente.getPassword());
        verify(gestioneUtenteDao,times(1)).loginCliente(cliente.getUsername(), cliente.getPassword());
    }

}
