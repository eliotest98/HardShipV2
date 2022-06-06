package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneFeedbackDao;
import io.hardship.hardshipapi.entity.Feedback;
import io.hardship.hardshipapi.entity.News;
import io.hardship.hardshipapi.entity.request.FeedbackDTO;
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
public class GestioneFeedbackServiceTest {

    @Mock
    private GestioneFeedbackDao gestioneFeedbackDao;
    @Autowired
    @InjectMocks
    private GestioneFeedbackServiceImpl gestioneFeedbackService;
    private FeedbackDTO feedback1;
    private FeedbackDTO feedback2;
    private Feedback RECORD_1;
    private Optional<FeedbackDTO> feedback3;
    List<Feedback> feedbackList;
    @BeforeEach
    public void setUp() {
        feedbackList = new ArrayList<Feedback>();
        RECORD_1 = new Feedback(1, "titolo1", "testo1","15-01-2022",1,1);
        feedback1 = new FeedbackDTO("titolo1", "testo1",1,1);
        feedback2 = new FeedbackDTO("titolo2", "testo2",2,2);
        feedback3 = Optional.of(new FeedbackDTO("titolo1", "testo1",3,3));
        feedbackList.add(RECORD_1);
        //feedbackList.add(feedback2);
    }

    @AfterEach
    public void tearDown() {
        feedback1 = feedback2 = null;
        feedbackList = null;
    }

    //Test Case for Saving a Feedback
    @Test
    void givenFeedbackToAddShouldReturnAddedFeedback() throws Exception{
        //stubbing
        when(gestioneFeedbackDao.save(any())).thenReturn(RECORD_1);
        gestioneFeedbackService.createFeedback(feedback1);
        verify(gestioneFeedbackDao,times(1)).save(any());
    }

    //Test Code for Retrieval of all Feedback
    @Test
    public void givenGetAllNewsShouldReturnListOfAllNews(){
        gestioneFeedbackDao.save(RECORD_1);
        //stubbing mock to return specific data
        when(gestioneFeedbackDao.findAll()).thenReturn(feedbackList);
        List<Feedback> feedbackList1 = gestioneFeedbackService.getAllFeedback();
        assertEquals(feedbackList1,feedbackList);
        verify(gestioneFeedbackDao,times(1)).save(RECORD_1);
        verify(gestioneFeedbackDao,times(1)).findAll();
    }



}

