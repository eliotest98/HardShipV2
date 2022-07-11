package io.hardship.hardshipapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.hardship.hardshipapi.entity.Brano;
import io.hardship.hardshipapi.entity.Feedback;
import io.hardship.hardshipapi.service.GestioneBranoService;
import io.hardship.hardshipapi.service.GestioneFeedbackService;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class GestioneBranoControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    GestioneBranoService gestioneBranoService;

    @InjectMocks
    private GestioneBranoController gestioneBranoController;

    @Mock
    private Brano RECORD_1;
    private Brano RECORD_2;
    private Brano RECORD_3;

    @BeforeEach
    public void setup() {
        RECORD_1 = new Brano(1, "titolo1", "2021", "2:30","track", 1, 1);
        RECORD_2 = new Brano(2, "titolo2", "2020", "2:00","track", 1, 2);
        RECORD_3 = new Brano(3, "titolo3", "2019", "4:00","track", 1, 3);
        mockMvc = MockMvcBuilders.standaloneSetup(gestioneBranoController).build();
    }

    @AfterEach
    void tearDown() {
        RECORD_1 = RECORD_2 = RECORD_3 = null;
    }

    @Test
    public void getBraniWithAlbumId() throws Exception {
        List<Brano> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        when(gestioneBranoService.getBraniWhitAlbumID(1)).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/brani/album/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].titolo", Matchers.is("titolo3")));
    }
}
