package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.*;
import io.hardship.hardshipapi.entity.*;
import io.hardship.hardshipapi.entity.request.AlbumDTO;
import io.hardship.hardshipapi.entity.request.RichiestaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestioneAlbumServiceImpl implements GestioneAlbumService {


    @Autowired
    GestioneArtistaDao gestioneArtistaDao;

    @Autowired
    GestioneEtichettaDao gestioneEtichettaDao;

    @Autowired
    GestioneAlbumDao gestioneAlbumDao;

    @Autowired
    GestiononeDigitaleDao gestiononeDigitaleDao;

    @Autowired
    GestioneVinileDao gestioneVinileDao;

    @Autowired
    GestioneCDDao gestioneCDDao;

    @Autowired
    GestioneBranoDao gestioneBranoDao;

    @Autowired
    GestioneRichiestaDao gestioneRichiestaDao;

    @Override
    public Optional<Album> getAlbum(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Album> getAllAlbum() {
        List<Album> albumList = gestioneAlbumDao.findAll();
        return albumList;
    }

    @Override
    public Optional<Album> createAlbum(AlbumDTO album) {
        Artista artista = gestioneArtistaDao.insertArtista(album.getAutore());
        Etichetta etichetta = gestioneEtichettaDao.insertEtichetta(album.getEtichetta());

        Album createAlbum = new Album(album.getGenere(), album.getTitolo(), album.getFile(), album.getNbrani(), album.getData(), "", album.getDettagli(), "root", artista.getId(), etichetta.getId());
        Album resultAlbum = gestioneAlbumDao.insertAlbum(createAlbum.getGenere(), createAlbum.getTitolo(), createAlbum.getCopertina(), createAlbum.getNumeroBrani(), createAlbum.getData(), createAlbum.getEmbed(), createAlbum.getDettagli(), createAlbum.getUsernameAdmin(), createAlbum.getIdEtichetta(), createAlbum.getIdArtista());

        Digitale createDigitale = new Digitale(album.getPdigitale(), album.getDigitale(), resultAlbum.getId());
        Digitale resultDigitale = gestiononeDigitaleDao.insertDigitale(createDigitale.getPrezzo() + "", createDigitale.getNumeroCopie(), createDigitale.getIdAlbum());

        Vinile createVinile = new Vinile(album.getPvinile(), album.getVinile(), resultAlbum.getId());
        Vinile resultVinile = gestioneVinileDao.insertVinile(createVinile.getPrezzo() + "", createVinile.getNumeroCopie(), createVinile.getIdAlbum());

        Cd createCD = new Cd(album.getPcd(), album.getCd(), resultAlbum.getId());
        Cd resultCD = gestioneCDDao.insertCD(createCD.getPrezzo() + "", createCD.getNumeroCopie(), createCD.getIdAlbum());

        for (int i = 0; i < album.getBrani().size() - 1; i++) {

            Brano createBrano = new Brano(album.getBrani().get(i), album.getData(), album.getDurate().get(i), resultAlbum.getId(), artista.getId());
            Brano resultBrano = gestioneBranoDao.insertAlbum(createBrano.getTitolo(), createBrano.getAnno(), createBrano.getDurata(), createBrano.getIdAlbum(), createBrano.getIdArtista());

        }
        return Optional.of(resultAlbum);
    }

    @Override
    public Optional<Richiesta> createRequestAlbum(RichiestaDTO richiestaDTO) {
        Richiesta newRequest = new Richiesta();
        Richiesta result = gestioneRichiestaDao.save(newRequest);
        return  Optional.of(result);
    }

    @Override
    public Optional getAlbumDetail(Integer pid) {
        Optional<Album> result = Optional.ofNullable(gestioneAlbumDao.findAlbumByPidLike(pid));
        return result;
    }
}
