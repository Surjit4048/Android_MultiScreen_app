package com.example.android.miwok;


class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;

    Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
    }

    String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    String getDefaultTranslation() {
        return mDefaultTranslation;
    }
}
