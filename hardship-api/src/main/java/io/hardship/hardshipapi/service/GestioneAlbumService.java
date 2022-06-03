package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.entity.Richiesta;
import io.hardship.hardshipapi.entity.request.AlbumDTO;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface GestioneAlbumService  {

    Optional<Album> getAlbum(Integer id);
    List<Album> getAllAlbum();
    Optional<Album> createAlbum(AlbumDTO album);
    Optional<Richiesta> createRequestAlbum();
    Optional<Album> getAlbumDetail(Integer pid);
}
