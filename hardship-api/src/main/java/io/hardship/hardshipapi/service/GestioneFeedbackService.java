package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.entity.Feedback;
import io.hardship.hardshipapi.entity.request.FeedbackDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface GestioneFeedbackService {
    Optional<Feedback> createFeedback(FeedbackDTO feedback) throws ParseException;
    List<Feedback> getAllFeedback();

}
