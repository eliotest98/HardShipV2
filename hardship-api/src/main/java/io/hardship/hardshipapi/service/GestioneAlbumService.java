package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.entity.Richiesta;
import io.hardship.hardshipapi.entity.request.AlbumDTO;
import io.hardship.hardshipapi.entity.request.RichiestaDTO;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface GestioneAlbumService  {

    List<Album> getAllAlbum();
    Optional<Album> createAlbum(AlbumDTO album);
    Optional<Richiesta> createRequestAlbum(RichiestaDTO richiestaDTO);
    Optional<Album> getAlbumDetail(Integer pid);
    void deleteRichiestaById(Integer pid);
}
