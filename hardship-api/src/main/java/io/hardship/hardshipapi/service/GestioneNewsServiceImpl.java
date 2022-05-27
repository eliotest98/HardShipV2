package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneNewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestioneNewsServiceImpl implements  GestioneNewsService{

    @Autowired
     GestioneNewsDao gesioneNewsDao;

    @Override
    public void getNews(Long id) {

    }
}
