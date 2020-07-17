package com.example.gallery.profile;

import com.example.gallery.datastore.FakeUserProfileDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileDataAccessService {

    private final FakeUserProfileDataStore fakeUserProfileDataStore;

    @Autowired
    public UserProfileDataAccessService(FakeUserProfileDataStore fakeUserProfileDataStore) {
        this.fakeUserProfileDataStore = fakeUserProfileDataStore;
    }

    List<UserProfile> getUserProfiles() {
        return fakeUserProfileDataStore.getuserprofiles();
    }

    public UUID setUserProfile(String name, String height, String weight) {
        UUID userId = UUID.randomUUID();
        fakeUserProfileDataStore.setUserProfile(userId, name, height, weight);
        return userId;
    }


}
