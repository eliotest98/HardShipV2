package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Brano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneBranoDao  extends JpaRepository<Brano, Integer> {
}
