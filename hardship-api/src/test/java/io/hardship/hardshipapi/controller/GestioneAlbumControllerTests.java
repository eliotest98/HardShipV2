package io.hardship.hardshipapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.Richiesta;
import io.hardship.hardshipapi.entity.request.RichiestaDTO;
import io.hardship.hardshipapi.service.GestioneAlbumService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class GestioneAlbumControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    GestioneAlbumService gestioneAlbumService;

    @InjectMocks
    private GestioneAlbumController gestioneAlbumController;

    @Mock
    private Album RECORD_1, RECORD_2;
    private Richiesta richiesta;
    private ArrayList<Album> albums = new ArrayList<>();

    @BeforeEach
    public void setup() {
        RECORD_1 = new Album(10, "Pop", "Black", "Black", 14, "02-06-2022", "bho", "Nuovo Album", "root", 0, 1);
        RECORD_2 = new Album(20, "Pop", "White", "White", 14, "02-06-2022", "bho", "Nuovo Album", "root", 1, 0);
        richiesta = new Richiesta(3, "Black", "Ciccio", 1);
        albums.add(RECORD_1);
        albums.add(RECORD_2);
        mockMvc = MockMvcBuilders.standaloneSetup(gestioneAlbumController).build();
    }

    @AfterEach
    void tearDown() {
        RECORD_1 = RECORD_2 = null;
        richiesta = null;
        albums = null;
    }

    @Test
    public void getAllAlbumsOrderByEtichetta() throws Exception {
        when(gestioneAlbumService.getAllAlbumsOrderByEtichetta()).thenReturn(albums);
        ResultActions a = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/albums/etichetta")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idEtichetta", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].idEtichetta", Matchers.is(1)));
    }

    @Test
    public void getAllAlbumsOrderByArtitsta() throws Exception {
        when(gestioneAlbumService.getAllAlbumsOrderByArtista()).thenReturn(albums);
        ResultActions a = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/albums/artista")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].idArtista", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idArtista", Matchers.is(1)));
    }

    @Test
    public void getDetailAlbum_success() throws Exception {
        when(gestioneAlbumService.getAlbumDetail(RECORD_1.getId())).thenReturn(Optional.of(RECORD_1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/album/detail/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.titolo", Matchers.is("Black")));
    }

    @Test
    public void uploadAlbum_success() throws Exception {
        when(gestioneAlbumService.createAlbum(any())).thenReturn(Optional.ofNullable(RECORD_1));
        mockMvc.perform(post("/api/v1/album").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(RECORD_1))).
                andExpect(status().isCreated());
        verify(gestioneAlbumService, times(1)).createAlbum(any());
    }

    @Test
    public void getAlbums_success() throws Exception {
        when(gestioneAlbumService.getAllAlbum()).thenReturn(albums);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/albums")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].titolo", Matchers.is("White")));
    }

    @Test
    public void createRequestAlbum_success() throws Exception {
        when(gestioneAlbumService.createRequestAlbum(any())).thenReturn(Optional.ofNullable(richiesta));
        mockMvc.perform(post("/api/v1/album/request").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(richiesta))).
                andExpect(status().isCreated());
        verify(gestioneAlbumService,times(1)).createRequestAlbum(any());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
