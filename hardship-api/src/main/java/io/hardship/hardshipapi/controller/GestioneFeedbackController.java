package io.hardship.hardshipapi.controller;

import io.hardship.hardshipapi.entity.Feedback;
import io.hardship.hardshipapi.entity.request.FeedbackDTO;
import io.hardship.hardshipapi.service.GestioneFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class GestioneFeedbackController {
    @Autowired
    public GestioneFeedbackService gestioneFeedbackService;

    @PostMapping("/feedback")
    ResponseEntity<Feedback> createFeedback(@RequestBody  FeedbackDTO feedback) throws ServerException {
        Optional<Feedback> result = gestioneFeedbackService.createFeedback(feedback);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
        } else {
            throw new ServerException("Feedback not created");
        }
    }

    @GetMapping("/feedbacks")
    ResponseEntity<List<Feedback>> getAllFeebacks( ) throws  ServerException{
        List<Feedback> result = gestioneFeedbackService.getAllFeedback();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
