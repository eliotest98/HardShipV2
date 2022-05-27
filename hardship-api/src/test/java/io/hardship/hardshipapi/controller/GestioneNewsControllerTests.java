package io.hardship.hardshipapi.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GestioneNewsControllerTests {

    @Autowired
    MockMvc mvc;

    @Test
    void getNews() throws Exception{
        long newsId = 1;
        mvc.perform(get("/api/v1/news/"+ newsId)).andExpect(status().isOk());
    }


}
