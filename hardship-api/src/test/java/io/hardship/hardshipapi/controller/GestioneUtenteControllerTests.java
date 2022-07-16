package io.hardship.hardshipapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.hardship.hardshipapi.entity.Cliente;
import io.hardship.hardshipapi.service.GestioneUtenteService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class GestioneUtenteControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    GestioneUtenteService gestioneUtenteService;

    @InjectMocks
    private GestioneUtenteController gestioneUtenteController;

    @Mock
    private Cliente RECORD_1;


    @BeforeEach
    public void setup() {

        RECORD_1 = new Cliente(1, "Pippo", "Pippo", "pippo98", "pippo_98", "pippo@libero.it", "15-02-1965", "PSPLEI09A05T807X");
        mockMvc = MockMvcBuilders.standaloneSetup(gestioneUtenteController).build();
    }

    @AfterEach
    void tearDown() {
        RECORD_1 = null;
    }

    @Test
    public void registraCliente_success() throws Exception {
        when(gestioneUtenteService.registraCliente(any())).thenReturn(1);
        mockMvc.perform(post("/api/v1/register").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(RECORD_1))).
                andExpect(status().isOk());
        verify(gestioneUtenteService,times(1)).registraCliente(any());
    }

    /*@Test
    public void loginCLiente() throws Exception {
        registraCliente_success();
        mockMvc.perform(post("/api/v1/login").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(RECORD_1))).
                andExpect(status().isOk());
        verify(gestioneUtenteService,times(1)).loginCliente(RECORD_1.getUsername(),RECORD_1.getPassword());
    }*/

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
