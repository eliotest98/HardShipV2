package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Brano;
import io.hardship.hardshipapi.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestioneFeedbackDao  extends JpaRepository<Feedback, Integer> {

    @Modifying
    @Query(value = "SELECT * FROM Feedback as feed,cliente as cli WHERE ID_Album=:id AND feed.ID_Cliente=cli.ID",nativeQuery = true)
    List<Feedback> getFeedbacksWithClientID(@Param("id") int id);

}
