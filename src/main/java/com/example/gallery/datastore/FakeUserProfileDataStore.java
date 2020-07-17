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
        USER_PROFILES.add(new UserProfile(UUID.fromString("a9cd2b54-cc4b-470e-9670-d487297b276d"), "Connor Mcgregor", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("fd1aef83-b374-4c0c-91cb-f3b2d11c9748"), "George Pierre", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("fddb040b-7813-458d-86f0-38439e6c8630"), "Seth Rollins", null));
    }

    public List<UserProfile> getuserprofiles () {
        return USER_PROFILES;
    }
}
