package io.hardship.hardshipapi.controller;

import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.Richiesta;
import io.hardship.hardshipapi.entity.request.AlbumDTO;
import io.hardship.hardshipapi.entity.request.RichiestaDTO;
import io.hardship.hardshipapi.service.GestioneAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class GestioneAlbumController {

    @Autowired
    public GestioneAlbumService gestioneAlbumService;

    @PostMapping("/album")
    ResponseEntity<Album> uploadAlbum(@RequestBody AlbumDTO album) throws ServerException {
        Optional<Album> result = gestioneAlbumService.createAlbum(album);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
        } else {
            throw new ServerException("Album not created");
        }
    }

    @DeleteMapping("/richiesta/delete/{pid}")
    ResponseEntity<Void> deleteRichiesta(@PathVariable Integer pid) {
        try {
            gestioneAlbumService.deleteRichiestaById(pid);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/album/detail/{pid}")
    ResponseEntity<Album> getDetailAlbum(@PathVariable Integer pid) throws ServerException {
        Optional<Album> result = gestioneAlbumService.getAlbumDetail(pid);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            throw new ServerException("Album not found");
        }
    }

    @GetMapping("/albums")
    ResponseEntity<List<Album>> getAlbums(){
        List<Album> result = gestioneAlbumService.getAllAlbum();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/album/request")
    ResponseEntity<Richiesta> createRequestAlbum(@RequestBody RichiestaDTO richiestaDTO) throws ServerException {
        Optional<Richiesta> result = gestioneAlbumService.createRequestAlbum(richiestaDTO);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
        } else {
            throw new ServerException("Request not created");
        }
    }

}
