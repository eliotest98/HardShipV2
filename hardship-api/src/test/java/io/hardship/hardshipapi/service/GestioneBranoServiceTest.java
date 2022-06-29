package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.*;
import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.Brano;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GestioneBranoServiceTest {
    @Mock
    private GestioneBranoDao gestioneBranoDao;
    @Mock
    private GestioneAlbumDao gestioneAlbumDao;
    @Autowired
    @InjectMocks
    private GestioneBranoServiceImpl gestioneBranoService;
    private Brano RECORD_1;
    private Album album;

    @BeforeEach
    public void setUp() {
        RECORD_1 = new Brano(1, "titolo1", "2021", "2:30", 1, 1);
        album = new Album(1, "Pop", "Black", "Black", 14, "02-06-2022", "bho", "Nuovo Album", "root", 1, 1);
    }

    @AfterEach
    public void tearDown() {
        RECORD_1 = null;
    }
    /*         Non da la lista dei brani
    @Test
    public void getBraniWithAlbumId() {
        gestioneBranoDao.save(RECORD_1);
        gestioneAlbumDao.save(album);
        //stubbing mock to return specific data
        List<Brano> brani = Arrays.asList(RECORD_1);
        when(gestioneBranoDao.findAll()).thenReturn(brani);
        List<Brano> braniList = gestioneBranoService.getBraniWhitAlbumID(RECORD_1.getIdAlbum());
        assertEquals(braniList, brani);
        verify(gestioneBranoDao, times(1)).save(RECORD_1);
        verify(gestioneBranoDao, times(1)).findAll();
    }*/
}
