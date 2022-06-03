package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.*;
import io.hardship.hardshipapi.entity.*;
import io.hardship.hardshipapi.entity.request.AlbumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestioneAlbumServiceImpl  implements  GestioneAlbumService {


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

    @Override
    public Optional<Album> getAlbum(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Album> getAllAlbum() {
        List<Album> albumList = gestioneAlbumDao.findAll();
        return  albumList;
    }

    @Override
    public Optional<Album> createAlbum(AlbumDTO album) {
        Artista artista = gestioneArtistaDao.insertIntoArtista(album.getAutore());
        Etichetta etichetta = gestioneEtichettaDao.insertIntoEtichetta(album.getEtichetta());

        Album createAlbum = new Album(album.getGenere(), album.getTitolo(), album.getFile(),  album.getNbrani(), album.getData(), "", album.getDettagli(), "root", artista.getId(), etichetta.getId() );
        Album resultAlbum = gestioneAlbumDao.save(createAlbum);

        Digitale createDigitale = new Digitale(album.getPdigitale(), album.getDigitale(), resultAlbum.getId());
        Digitale resultDigitale = gestiononeDigitaleDao.save(createDigitale);

        Vinile createVinile = new Vinile(album.getPvinile(), album.getVinile(), resultAlbum.getId());
        Vinile resultVinile = gestioneVinileDao.save(createVinile);

        Cd createCD = new Cd(album.getPcd(), album.getCd(), resultAlbum.getId());
        Cd resultCD = gestioneCDDao.save(createCD);

        for (int i = 0; i < album.getBrani().size() - 1; i++) {

            Brano createBrano = new Brano(album.getBrani().get(i),  album.getData(), album.getDurate().get(i),resultAlbum.getId(),artista.getId());
            Brano resultBrano = gestioneBranoDao.save(createBrano);

        }
        return Optional.of(resultAlbum);
    }

    @Override
    public Optional<Richiesta> createRequestAlbum() {
        Richiesta result = null;// = gestioneAlbumDao.save();
        return Optional.of(result);
    }

    @Override
    public Optional getAlbumDetail(Integer pid) {
        Optional<Album> result = Optional.ofNullable(gestioneAlbumDao.findAlbumByPidLike(pid));
        return result;
    }
}
