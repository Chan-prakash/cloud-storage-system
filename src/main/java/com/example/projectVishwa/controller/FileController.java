package com.example.projectVishwa.controller;

import com.example.projectVishwa.service.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private GoogleDriveService googleDriveService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        try {
            // Convert MultipartFile to File
            File file = convertMultiPartToFile(multipartFile);
            String fileUrl = googleDriveService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully: " + fileUrl);
        } catch (IOException | GeneralSecurityException e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        }
        return convFile;
    }
}

