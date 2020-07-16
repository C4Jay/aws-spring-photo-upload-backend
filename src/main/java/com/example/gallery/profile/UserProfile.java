package com.example.gallery.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    private UUID userId;
    private String name;
    private String userProfileImageLink;

    public UserProfile(UUID userId, String name, String userProfileImageLink) {
        this.userId = userId;
        this.name = name;
        this.userProfileImageLink = userProfileImageLink;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, userProfileImageLink);
    }
}
