package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.entity.News;

import java.util.List;
import java.util.Optional;

public interface GestioneNewsService {

    Optional<News> getNews(Long id);
    List<News> getAllNews();
    Optional<News> createNews(News news);
}
