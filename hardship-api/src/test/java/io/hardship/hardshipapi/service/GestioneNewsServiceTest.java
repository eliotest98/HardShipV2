package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneNewsDao;
import io.hardship.hardshipapi.entity.News;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GestioneNewsServiceTest {

    @Mock
    private GestioneNewsDao gestioneNewsDao;
    @Autowired
    @InjectMocks
    private GestioneNewsServiceImpl gestioneNewsService;
    private News news1;
    private News news2;
    private Optional<News> news3;
    List<News> newsList;
    @BeforeEach
    public void setUp() {
        newsList = new ArrayList<>();
        news1 = new News(1, "contenuto1", "15-01-2022", "autore1","titolo1","copertina1","categoria1","pippo1");
        news2 = new News(2, "contenuto2", "16-01-2022", "autore2","titolo2","copertina2","categoria2","pippo2");
        news3 = Optional.of(new News(4, "contenuto4", "18-01-2022", "autore4", "titolo4", "copertina4", "categoria4", "pippo4"));
        newsList.add(news1);
        newsList.add(news2);
    }

    @AfterEach
    public void tearDown() {
        news1 = news2 = null;
        newsList = null;
    }

    //Test Case for Saving a News
    @Test
    void givenNewsToAddShouldReturnAddedNews() throws Exception{
        //stubbing
        when(gestioneNewsDao.save(any())).thenReturn(news1);
        gestioneNewsService.createNews(news1);
        verify(gestioneNewsDao,times(1)).save(any());
    }

    //Test Code for Retrieval of all News
    @Test
    public void givenGetAllNewsShouldReturnListOfAllNews(){
        gestioneNewsDao.save(news1);
        //stubbing mock to return specific data
        when(gestioneNewsDao.findAll()).thenReturn(newsList);
        List<News> newsList1 = gestioneNewsService.getAllNews();
        assertEquals(newsList1,newsList);
        verify(gestioneNewsDao,times(1)).save(news1);
        verify(gestioneNewsDao,times(1)).findAll();
    }

    //Test Case to Retrieve a News by Id
    @Test
    public void givenIdThenShouldReturnNewsOfThatId() {
        Mockito.when(gestioneNewsDao.findById(4)).thenReturn(news3);
        assertThat(gestioneNewsService.getNews(4)).isEqualTo(news3);
    }

}
