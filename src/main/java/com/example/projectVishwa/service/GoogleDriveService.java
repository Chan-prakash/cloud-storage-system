package com.example.projectVishwa.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.client.http.FileContent;

@Service
public class GoogleDriveService {

    private String googleFolderId = "your-google-drive-folder-id"; // Set your folder ID if needed

    // Add this method for file upload
    public String uploadFile(java.io.File file) throws GeneralSecurityException, IOException {
        Drive driveService = getDriveService();

        // Create file metadata
        File fileMetadata = new File();
        fileMetadata.setName(file.getName());
        fileMetadata.setParents(Collections.singletonList(googleFolderId)); // Optional, specify a folder if needed

        // Create media content (the file to upload)
        FileContent mediaContent = new FileContent("application/octet-stream", file);

        // Upload the file
        File uploadedFile = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id, webViewLink")
                .execute();

        // Return the URL for the uploaded file
        return uploadedFile.getWebViewLink();
    }

    // Other methods like getDriveService()
    private Drive getDriveService() throws GeneralSecurityException, IOException {
		return null;
        // Implement the method to return a Google Drive service object
    }
}
