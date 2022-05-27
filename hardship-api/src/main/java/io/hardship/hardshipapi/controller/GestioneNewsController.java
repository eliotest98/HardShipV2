package io.hardship.hardshipapi.controller;

import io.hardship.hardshipapi.service.GestioneUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController è l’annotazione di Spring Boot che serve per dichiarare che stiamo creando un Controller.
@RequestMapping("/api/v1") // rappresenta la prima parte di path dopo https://localhost:port/api/v1
public class GestioneNewsController {

    @Autowired
    private GestioneUtenteService gestioneUtenteService;
    @GetMapping("/news/{newsId}") //  https://localhost:port/api/v1/news/10
    void getNews(@PathVariable Long id){

    }

}
