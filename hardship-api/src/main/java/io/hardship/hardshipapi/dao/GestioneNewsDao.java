package io.hardship.hardshipapi.dao;


import io.hardship.hardshipapi.entity.News;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface GestioneNewsDao extends JpaRepository<News, Long>  {

}
