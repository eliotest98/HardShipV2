package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneFeedbackDao  extends JpaRepository<Feedback, Integer> {

}
