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
    private int registraCliente(@RequestBody Cliente nuovoCliente) {
        return gestioneUtenteService.registraCliente(nuovoCliente);
    }

    @GetMapping("/login")
    private Cliente loginCliente(@RequestBody Cliente cliente) {
        return gestioneUtenteService.loginCliente(cliente.getUsername(),cliente.getPassword());
    }

}
