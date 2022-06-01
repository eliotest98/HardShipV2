package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneNewsDao;
import io.hardship.hardshipapi.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestioneNewsServiceImpl implements  GestioneNewsService{

    @Autowired
     GestioneNewsDao gesioneNewsDao;

    @Override
    public  Optional<News> getNews(Long id) {
        Optional<News> result = gesioneNewsDao.findById(id);
        return result;
    }

    @Override
    public List<News> getAllNews() {
        List<News> result = gesioneNewsDao.findAll();
        return result;
    }

    @Override
    public Optional<News> createNews(News news) {
        News result = gesioneNewsDao.save(news);
        return Optional.of(result);
    }
}
