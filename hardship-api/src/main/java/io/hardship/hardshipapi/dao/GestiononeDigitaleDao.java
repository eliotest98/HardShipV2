package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Digitale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestiononeDigitaleDao   extends JpaRepository<Digitale, Integer> {
}
