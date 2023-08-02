package poly.edu.asmjava5.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Service
public interface StorageService {
    String getStoredFilename(MultipartFile file, String id);

    void store(MultipartFile file, String storedFilename);

    Resource loadAsResource(String filename);

    Path load(String filename);

    void delete(String storedFilename) throws IOException;

    void init();
}
