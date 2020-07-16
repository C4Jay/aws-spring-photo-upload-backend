package com.example.gallery.bucket;

public enum BucketName {

    PROFILE_IMAGE("gallery-storage");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
