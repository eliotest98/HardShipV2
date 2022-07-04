package io.hardship.hardshipapi.service;

import org.springframework.core.io.Resource;

public interface FilesStorageService {
    public void init();
    public Resource load(String filename);
}
