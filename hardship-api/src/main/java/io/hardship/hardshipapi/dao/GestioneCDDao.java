package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface GestioneCDDao  extends JpaRepository<Cd, Integer> {
}
