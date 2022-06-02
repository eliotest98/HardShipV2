package io.hardship.hardshipapi.controller;

import io.hardship.hardshipapi.entity.Album;

import io.hardship.hardshipapi.entity.Richiesta;
import io.hardship.hardshipapi.service.GestioneAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class GestioneAlbumController {

    @Autowired
    public GestioneAlbumService gestioneAlbumService;

    @PostMapping("/album")
    ResponseEntity<Album> createAlbum(@RequestBody Album item) throws ServerException {
        Optional<Album> album = gestioneAlbumService.createAlbum(item);
        if (album.isPresent()) {
            return new ResponseEntity<>(album.get(), HttpStatus.CREATED);
        } else {
            throw new ServerException("Album created");
        }
    }

    @PostMapping("/album/request")
    ResponseEntity<Richiesta> createRequestAlbum() throws ServerException {
        Optional<Richiesta> request = gestioneAlbumService.createRequestAlbum();
        if (request.isPresent()) {
            return new ResponseEntity<>(request.get(), HttpStatus.CREATED);
        } else {
            throw new ServerException("Richiesta not created");
        }
    }

    @GetMapping("/album/detail/{pid}")
    ResponseEntity<Album> getDetailAlbum(@PathVariable Integer pid) throws ServerException {
        Optional<Album> request = gestioneAlbumService.getAlbumDetail(pid);
        if (request.isPresent()) {
            return new ResponseEntity<>(request.get(), HttpStatus.OK);
        } else {
            throw new ServerException("Album not found ");
        }
    }
}
