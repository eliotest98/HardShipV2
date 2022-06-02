package io.hardship.hardshipapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.service.GestioneNewsService;
import io.hardship.hardshipapi.service.GestioneNewsServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class GestioneNewsControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    GestioneNewsService gestioneNewsService;

    @InjectMocks
    private GestioneNewsController gestioneNewsController;

    @Mock
    private News RECORD_1;
    private News RECORD_2;
    private News RECORD_3;

    private List<News> newsList;


    @BeforeEach
    public void setup(){

        RECORD_1 = new News(1, "contenuto1", "15-01-2022", "autore1","titolo1","copertina1","categoria1","pippo1");
        RECORD_2 = new News(2, "contenuto2", "16-01-2022", "autore2","titolo2","copertina2","categoria2","pippo2");
        RECORD_3 = new News(3, "contenuto3", "17-01-2022", "autore3","titolo3","copertina3","categoria3","pippo3");
        mockMvc = MockMvcBuilders.standaloneSetup(gestioneNewsController).build();
    }
    @AfterEach
    void tearDown() {
        RECORD_1 = null;
    }

    @Test
    public void getAllNews_success() throws Exception {
        List<News> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        when(gestioneNewsService.getAllNews()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/news/allNews")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].contenuto", Matchers.is("contenuto3")));
    }

    @Test
    public void getNewsById_success() throws Exception {
        when(gestioneNewsService.getNews(RECORD_1.getId())).thenReturn(Optional.of(RECORD_1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/news/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.contenuto", Matchers.is("contenuto1")));
    }


    @Test
    public void createNews_success() throws Exception{
        when(gestioneNewsService.createNews(any())).thenReturn(Optional.ofNullable(RECORD_1));
        mockMvc.perform(post("/api/v1/news").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(RECORD_1))).
                andExpect(status().isCreated());
        verify(gestioneNewsService,times(1)).createNews(any());
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



}
