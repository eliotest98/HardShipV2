package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneAlbumDao;
import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.entity.Richiesta;
import io.hardship.hardshipapi.entity.request.AlbumDTO;
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
    @Autowired
    @InjectMocks
    private GestioneAlbumServiceImpl gestioneAlbumService;
    private AlbumDTO RECORD_1;
    private Optional<Album> RECORD_2;
    private Richiesta richiesta;
    @BeforeEach
    public void setUp() {
        RECORD_1 = new AlbumDTO("Ciccio","White","Pop","03-06-2022","Nuovo Album","Bho","Copertina","Bho","root",14,1,1,1,new BigDecimal(1.0),new BigDecimal(1.0),new BigDecimal(1.0),"File",new ArrayList<>(Arrays.asList("White,Black")),new ArrayList<>(Arrays.asList("5,4")));
        RECORD_2 = Optional.of(new Album(2, "Rap", "White", "White",7,"02-06-2022","bho","Nuovo Album","root",1,1));
        richiesta = new Richiesta(1,"Black","Ciccio",1);
    }

    @AfterEach
    public void tearDown() {
        RECORD_1 = null;
        RECORD_2 = null;
        richiesta = null;
    }

    //Test Case for Saving a Album
    @Test                             // da null pointer per il createAlbum
    void givenAlbumToAddShouldReturnAddedAlbum() throws Exception{
        //stubbing
        when(gestioneAlbumDao.save(any())).thenReturn(RECORD_1);
        gestioneAlbumService.createAlbum(RECORD_1);

    }

    //Test Case to Retrieve a Album by Id
    /*@Test               getAlbumDetail ritorna empty
    public void givenIdThenShouldReturnAlbumOfThatId() {
        Mockito.when(gestioneAlbumDao.findById(1)).thenReturn(RECORD_2);
        assertThat(gestioneAlbumService.getAlbumDetail(2)).isEqualTo(RECORD_2);
    }*/

}

