package com.example.gallery.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-profile")
//@CrossOrigin("*")
@CrossOrigin(origins = "*")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public  UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfile> getUserProfiles () {
        return userProfileService.getUserProfiles();
    }

    @PostMapping(
            path = "{userProfileId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId,
                                       @RequestParam("file") MultipartFile file) {
        userProfileService.uploadUserProfileImage(userProfileId, file);
    }


    @GetMapping("{userProfileId}/image/dwnld")
    public byte[] dwnldUserProfileImage(@PathVariable("userProfileId") UUID userProfileId) {
        return userProfileService.dwnldUserProfileImage(userProfileId);
    }


    @PostMapping(path = "/set-user/{name}/{height}/{weight}")
//    @RequestMapping(value = "/set-user/{name}", method = RequestMethod.POST)
//    @ResponseBody
    public UUID setUserProfile(@PathVariable("name") String name, @PathVariable("height") String height, @PathVariable("weight") String weight) {
        return userProfileService.setUserProfile(name, height, weight);
    }
}
