package io.hardship.hardshipapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.hardship.hardshipapi.controller.GestioneFeedbackController;
import io.hardship.hardshipapi.entity.Brano;
import io.hardship.hardshipapi.entity.Feedback;
import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.service.GestioneFeedbackService;
import io.hardship.hardshipapi.service.GestioneNewsService;
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
import java.util.Optional;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class GestioneFeedbackControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    GestioneFeedbackService gestioneFeedbackService;

    @InjectMocks
    private GestioneFeedbackController gestioneFeedbackController;

    @Mock
    private Feedback RECORD_1;
    private Feedback RECORD_2;
    private Feedback RECORD_3;



    @BeforeEach
    public void setup(){
        RECORD_1 = new Feedback(1, "titolo1", "testo1","15-01-2022",1,1);
        RECORD_2 = new Feedback(2, "titolo2", "testo2","16-01-2022",2,1);
        RECORD_3 = new Feedback(3, "titolo3", "testo3","17-01-2022",3,1);
        mockMvc = MockMvcBuilders.standaloneSetup(gestioneFeedbackController).build();
    }
    @AfterEach
    void tearDown() {
        RECORD_1 = RECORD_2 = RECORD_3 = null;
    }

    @Test
    public void getAllFeedback_success() throws Exception {
        List<Feedback> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        when(gestioneFeedbackService.getAllFeedback()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/feedbacks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].titolo", Matchers.is("titolo3")));
    }



    @Test
    public void createNews_success() throws Exception{
        when(gestioneFeedbackService.createFeedback(any())).thenReturn(Optional.ofNullable(RECORD_1));
        mockMvc.perform(post("/api/v1/feedback").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(RECORD_1))).
                andExpect(status().isCreated());
        verify(gestioneFeedbackService,times(1)).createFeedback(any());
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getFeedbackWithClientID() throws Exception {
        List<Feedback> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        when(gestioneFeedbackService.getFeedbacksWithClientID(1)).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/feedbacks/cliente/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].titolo", Matchers.is("titolo3")));
    }

}


