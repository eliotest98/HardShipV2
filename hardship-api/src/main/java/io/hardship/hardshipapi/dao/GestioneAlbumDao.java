package io.hardship.hardshipapi.dao;

import io.hardship.hardshipapi.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestioneAlbumDao extends JpaRepository<Album, Integer> {
}
