package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneNewsDao;
import org.springframework.beans.factory.annotation.Autowired;

public class GestioneNewsServiceImpl implements  GestioneNewsService{
    @Autowired
    private GestioneNewsDao gesioneNewsDao;

    @Override
    public void getNews(Long id) {

    }
}
