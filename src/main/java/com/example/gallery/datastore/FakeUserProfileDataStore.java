package com.example.gallery.datastore;

import com.example.gallery.profile.UserProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
//        USER_PROFILES.add(new UserProfile(UUID.fromString("a9cd2b54-cc4b-470e-9670-d487297b276d"), "Connor Mcgregor", null, "182", "145"));
//        USER_PROFILES.add(new UserProfile(UUID.fromString("fd1aef83-b374-4c0c-91cb-f3b2d11c9748"), "George Pierre", null, "178", "189"));
//        USER_PROFILES.add(new UserProfile(UUID.fromString("fddb040b-7813-458d-86f0-38439e6c8630"), "Seth Rollins", null, "194", "216"));
    }

    public List<UserProfile> getuserprofiles () {
        return USER_PROFILES;
    }

    public void setUserProfile(UUID userId, String name, String height, String weight) {
        USER_PROFILES.add(new UserProfile(userId, name, null, height, weight));
//        UserProfile user = new UserProfile(userId, name, null);

    }
}
