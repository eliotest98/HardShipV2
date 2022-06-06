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
    public List<Album> getAllAlbum() {
        List<Album> albumList = gestioneAlbumDao.findAll();
        return albumList;
    }

    @Override
    public Optional<Album> createAlbum(AlbumDTO album) {
        System.out.println("1");
        Artista artista = gestioneArtistaDao.save(new Artista(1,album.getAutore()));
        System.out.println("2");
        Etichetta etichetta = gestioneEtichettaDao.save(new Etichetta(1,album.getEtichetta(), 1)); //TODO il feed che è?
        System.out.println("3");
        Album album1 = gestioneAlbumDao.save(new Album(album.getGenere(), album.getTitolo(), album.getCopertina(), album.getNbrani(), album.getData(), album.getEmbed(), album.getDettagli(), album.getUsernameAdmin(), etichetta.getId(), artista.getId()));
        Digitale digitale = gestiononeDigitaleDao.save(new Digitale(album.getPdigitale(), album.getNbrani(), album1.getId()));
        Vinile vinile = gestioneVinileDao.save(new Vinile(album.getPvinile(), album.getNbrani(), album1.getId()));
        Cd cd = gestioneCDDao.save(new Cd(album.getPcd(), album.getNbrani(), album1.getId()));
        for (int i = 0; i < album.getBrani().size() - 1; i++) {
            Brano brano = gestioneBranoDao.save(new Brano(album.getBrani().get(i), "2022", album.getDurate().get(i), album1.getId(), artista.getId()));
        }
        return Optional.of(album1);
    }

    @Override
    public Optional<Richiesta> createRequestAlbum(RichiestaDTO richiestaDTO) {
        Richiesta result = gestioneRichiestaDao.save(new Richiesta(richiestaDTO.getTitolo(), richiestaDTO.getArtista(), richiestaDTO.getIdCliente()));
        return Optional.of(result);
    }

    @Override
    public Optional getAlbumDetail(Integer pid) {
        Optional<Album> result = gestioneAlbumDao.findById(pid);
        return result;
    }

    @Override
    public void deleteRichiestaById(Integer pid) {
        gestioneRichiestaDao.deleteById(pid);
    }


}
