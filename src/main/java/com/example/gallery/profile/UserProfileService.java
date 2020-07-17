package com.example.gallery.profile;

import com.example.gallery.bucket.BucketName;
import com.example.gallery.filestore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }
    List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        //if file present
        if(file.isEmpty()) {
            throw new IllegalStateException("No file selected");
        }
        //if it is an img
        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("No file selected");
        }

//        if user exists
//        UserProfile user = userProfileDataAccessService
//                .getUserProfiles()
//                .stream()
//                .filter(userProfile -> userProfile.getUserId().equals(userProfileId))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException(String.format("user profile %s does not exist", userProfileId)));

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), userProfileId );
        String namefile = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());

        try {
            fileStore.save(path, namefile, Optional.of(metadata), file.getInputStream());
            UserProfile user = userProfileDataAccessService.getUserProfiles()
                    .stream()
                    .filter(userprofile -> userprofile.getUserId().equals(userProfileId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("no user"));
            user.setUserProfileImageLink(namefile);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }


    byte[] dwnldUserProfileImage(UUID userProfileId) {
        UserProfile user = userProfileDataAccessService
                .getUserProfiles()
                .stream()
                .filter(userProfile -> userProfile.getUserId().equals(userProfileId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("no user"));
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), userProfileId );

        return user.getUserProfileImageLink()
                .map(key -> fileStore.dwnld(path, key))
                .orElse(new byte[0]);



    }

    public UUID setUserProfile(String name, String height, String weight) {
        return userProfileDataAccessService.setUserProfile(name, height, weight);
    }

}
