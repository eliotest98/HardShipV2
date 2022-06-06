package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneFeedbackDao;
import io.hardship.hardshipapi.dao.GestioneNewsDao;
import io.hardship.hardshipapi.entity.Album;
import io.hardship.hardshipapi.entity.Feedback;
import io.hardship.hardshipapi.entity.request.FeedbackDTO;
import io.hardship.hardshipapi.utils.DateFormatter;
import io.hardship.hardshipapi.utils.FormatDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GestioneFeedbackServiceImpl implements GestioneFeedbackService{

    @Autowired
    GestioneFeedbackDao gestioneFeedbackDao;
    @Override
    public Optional<Feedback> createFeedback(FeedbackDTO feedback) throws ParseException {
        Date newDate =  new Date();
        String currentDate = DateFormatter.dateFormatterByDate(newDate , FormatDateType.DDMMYYYY_SLASH);
        Feedback createFeedback = new Feedback(feedback.getTitolo(),feedback.getTesto(), currentDate,  feedback.getIdAlbum(), feedback.getUtente());
        Feedback result = gestioneFeedbackDao.save(createFeedback);
        return Optional.of(result);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = gestioneFeedbackDao.findAll();
        return feedbackList;
    }
}
