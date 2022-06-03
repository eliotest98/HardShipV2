package io.hardship.hardshipapi.controller;

import io.hardship.hardshipapi.entity.Cliente;
import io.hardship.hardshipapi.service.GestioneUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class GestioneUtenteController {

    @Autowired
    public GestioneUtenteService gestioneUtenteService;

    @PostMapping("/register")
    private Cliente registraCliente(@RequestBody Cliente nuovoCliente) {
        return gestioneUtenteService.registraCliente(nuovoCliente);
    }



}
