package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GestioneUtenteDao extends JpaRepository<Cliente, Long> {
}
