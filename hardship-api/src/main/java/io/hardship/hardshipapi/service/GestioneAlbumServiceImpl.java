package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneAlbumDao;
import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.entity.Richiesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestioneAlbumServiceImpl  implements  GestioneAlbumService {

    @Autowired
    GestioneAlbumDao gestioneAlbumDao;

    @Override
    public Optional<Album> getAlbum(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Album> getAllAlbum() {
        return null;
    }

    @Override
    public Optional<Album> createAlbum(Album album) {
        Album result = gestioneAlbumDao.save(album);
        return Optional.of(result);
    }

    @Override
    public Optional<Richiesta> createRequestAlbum() {
        Richiesta result = null;// = gestioneAlbumDao.save();
        return Optional.of(result);
    }

    @Override
    public Optional getAlbumDetail(Integer pid) {
        Optional<Album> result = gestioneAlbumDao.findById(pid);
        return result;
    }
}
