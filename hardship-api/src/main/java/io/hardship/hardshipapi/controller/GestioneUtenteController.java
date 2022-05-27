package io.hardship.hardshipapi.controller;

import io.hardship.hardshipapi.entity.Cliente;
import io.hardship.hardshipapi.service.GestioneUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GestioneUtenteController {

    @Autowired
    private GestioneUtenteService gestioneUtenteService;


    @PostMapping("/register")
    private Cliente registraCliente(@RequestBody Cliente nuovoCliente) {
        return gestioneUtenteService.registraCliente(nuovoCliente);
    }
}
