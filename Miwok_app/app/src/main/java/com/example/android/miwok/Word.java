package com.example.android.miwok;


class Word {

    public static final int NO_IMAGE_GIVEN = -1;

    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageId = NO_IMAGE_GIVEN;
    private int audioId;

    public Word(String mMiwokTranslation, String mDefaultTranslation, int audioId) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.audioId = audioId;
    }

    Word(String mDefaultTranslation, String mMiwokTranslation, int imageId, int audioId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageId = imageId;
        this.audioId = audioId;
    }

    String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    int getImageId() {
        return mImageId;
    }

    boolean hasImage() {
        return mImageId != NO_IMAGE_GIVEN;
    }

    public int getAudioId() {
        return audioId;
    }
}
