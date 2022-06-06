package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneAlbumDao;
import io.hardship.hardshipapi.dao.GestioneRichiestaDao;
import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.entity.Richiesta;
import io.hardship.hardshipapi.entity.request.AlbumDTO;
import io.hardship.hardshipapi.entity.request.RichiestaDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GestioneAlbumServiceTest {

    @Mock
    private GestioneAlbumDao gestioneAlbumDao;
    @Mock
    private GestioneRichiestaDao gestioneRichiestaDao;
    @Autowired
    @InjectMocks
    private GestioneAlbumServiceImpl gestioneAlbumService;
    private AlbumDTO RECORD_1;
    private Optional<Album> RECORD_2;
    private Album record1;
    private Richiesta richiesta;
    private RichiestaDTO richiestaDTO;

    @BeforeEach
    public void setUp() {
        RECORD_1 = new AlbumDTO("Ciccio", "White", "Pop", "03-06-2022", "Nuovo Album", "Bho", "Copertina", "Bho", "root", 14, 1, 1, 1, 1, new BigDecimal(1.0), new BigDecimal(1.0), new BigDecimal(1.0), "File", new ArrayList<>(Arrays.asList("White,Black")), new ArrayList<>(Arrays.asList("5,4")));
        record1 = new Album(1, "Pop", "White", "Copertina", 14, "03-06-2022", "Bho", "Nuovo Album", "root", 1, 1);
        RECORD_2 = Optional.of(new Album(2, "Rap", "White", "White", 7, "02-06-2022", "bho", "Nuovo Album", "root", 1, 1));
        richiesta = new Richiesta(1, "Black", "Ciccio", 1);
        richiestaDTO = new RichiestaDTO("Ciccio", "Black", 1);
    }

    @AfterEach
    public void tearDown() {
        RECORD_1 = null;
        record1 = null;
        richiesta = null;
        richiestaDTO = null;
    }

    //Test Case for Saving a Album
    /*@Test                             // da null pointer al 1 dao nel metodo
    void givenAlbumToAddShouldReturnAddedAlbum() throws Exception{
        //stubbing
        when(gestioneAlbumDao.save(any())).thenReturn(record1);
        gestioneAlbumService.createAlbum(RECORD_1);
        verify(gestioneAlbumDao,times(1)).save(any());
    }*/

    //Test Case for Create Request Album
    /*@Test
    void createRequestAlbumTest() throws Exception {
        //stubbing
        when(gestioneAlbumDao.save(any())).thenReturn(richiesta);
        gestioneAlbumService.createRequestAlbum(richiestaDTO);
        verify(gestioneAlbumDao, times(1)).save(any());
    }*/

    //Test Case to Retrieve a Album by Id
    @Test
    public void givenIdThenShouldReturnAlbumOfThatId() {
        Mockito.when(gestioneAlbumDao.findById(2)).thenReturn(RECORD_2);
        assertThat(gestioneAlbumService.getAlbumDetail(2)).isEqualTo(RECORD_2);
    }

    @Test
    public void getAllAlbumsTest() {
        gestioneAlbumDao.save(record1);
        //stubbing mock to return specific data
        List<Album> albums = Arrays.asList(record1);
        when(gestioneAlbumDao.findAll()).thenReturn(albums);
        List<Album> albumList = gestioneAlbumService.getAllAlbum();
        assertEquals(albumList, albums);
        verify(gestioneAlbumDao, times(1)).save(record1);
        verify(gestioneAlbumDao, times(1)).findAll();
    }

}

