package io.hardship.hardshipapi.service;

import io.hardship.hardshipapi.entity.Brano;

import java.util.List;

public interface GestioneBranoService {

    List<Brano> getBraniWhitAlbumID(int id);
}
