package io.hardship.hardshipapi.controller;

import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.service.GestioneNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController // @RestController è l’annotazione di Spring Boot che serve per dichiarare che stiamo creando un Controller.
@RequestMapping("/api/v1") // rappresenta la prima parte di path dopo https://localhost:port/api/v1

public class GestioneNewsController {

    @Autowired
    public GestioneNewsService gestioneNewsService;


    @GetMapping("/news/{newsId}") //  https://localhost:port/api/v1/news/10
    ResponseEntity<News> getNews(@PathVariable Integer newsId) throws ServerException{
        Optional<News> news = gestioneNewsService.getNews(newsId);
        if (news.isPresent()) {
            return new ResponseEntity<>(news.get(), HttpStatus.OK);
        } else {
            throw new ServerException("News not found");
        }
    }

    @GetMapping("/news/allNews")
    ResponseEntity<List<News>>  getAllNews() throws ServerException{
        //String urlCopertina =
        List<News> allNews = gestioneNewsService.getAllNews();

        return new ResponseEntity<>(allNews, HttpStatus.OK);
    }



    @PostMapping("/news")
    ResponseEntity<News> createNews(@RequestBody News item) throws ServerException {
        Optional<News> news = gestioneNewsService.createNews(item);
        if (news.isPresent()) {
            return new ResponseEntity<>(news.get(), HttpStatus.CREATED);
        } else {
            throw new ServerException("News not created");

        }
    }




}
