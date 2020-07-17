package com.example.gallery.bucket;

public enum BucketName {

    PROFILE_IMAGE("aws-photo-bucket-storage-2");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
