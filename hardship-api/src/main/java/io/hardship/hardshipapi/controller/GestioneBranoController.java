package io.hardship.hardshipapi.controller;

import io.hardship.hardshipapi.entity.Brano;
import io.hardship.hardshipapi.service.GestioneBranoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GestioneBranoController {

    @Autowired
    public GestioneBranoService gestioneBranoService;

    @GetMapping("/brani/album/{pid}")
    ResponseEntity<List<Brano>> getBraniWhitAlbumID(@PathVariable Integer pid) throws ServerException {
        List<Brano> result = gestioneBranoService.getBraniWhitAlbumID(pid);
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            throw new ServerException("Brani not found");
        }
    }
}
