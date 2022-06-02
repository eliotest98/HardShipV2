package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneFeedbackDao;
import io.hardship.hardshipapi.dao.GestioneNewsDao;
import io.hardship.hardshipapi.entity.Feedback;
import io.hardship.hardshipapi.entity.request.FeedbackDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestioneFeedbackServiceImpl implements GestioneFeedbackService{

    @Autowired
    GestioneFeedbackDao gestioneFeedbackDao;
    @Override
    public Optional<Feedback> createFeedback(FeedbackDTO feedback) {
        return Optional.empty();
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return null;
    }
}
