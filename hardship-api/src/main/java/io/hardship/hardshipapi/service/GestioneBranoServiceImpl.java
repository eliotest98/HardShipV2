package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.dao.GestioneBranoDao;
import io.hardship.hardshipapi.entity.Brano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestioneBranoServiceImpl implements GestioneBranoService {

    @Autowired
    GestioneBranoDao gestioneBranoDao;

    @Override
    public List<Brano> getBraniWhitAlbumID(int id) {
        return gestioneBranoDao.getBraniWhitAlbumID(id);
    }
}
