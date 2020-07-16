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
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Connor Mcgregor", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "George Pierre", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Seth Rollins", null));
    }

    public List<UserProfile> getuserprofiles () {
        return USER_PROFILES;
    }
}
