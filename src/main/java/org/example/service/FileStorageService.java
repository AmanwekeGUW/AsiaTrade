package org.example.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService  {
    private static final String Upload ="/Users/lblpp/OneDrive/Рабочий стол/REACT/serik/src/images/";

    public String storeFile(MultipartFile imageFile) {
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = Paths.get(Upload + fileName);
            Files.copy(imageFile.getInputStream(), targetLocation);

            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
