package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class StoryMessage implements Parcelable {
    public static final Parcelable.Creator<StoryMessage> CREATOR = new Parcelable.Creator<StoryMessage>() { // from class: com.sina.weibo.sdk.api.StoryMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoryMessage createFromParcel(Parcel parcel) {
            return new StoryMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoryMessage[] newArray(int i2) {
            return new StoryMessage[i2];
        }
    };
    private Uri imageUri;
    private Uri videoUri;

    public StoryMessage() {
    }

    public boolean checkResource() {
        Uri uri = this.imageUri;
        if (uri == null || this.videoUri == null) {
            return (uri == null && this.videoUri == null) ? false : true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Uri getVideoUri() {
        return this.videoUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setVideoUri(Uri uri) {
        this.videoUri = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.imageUri, i2);
        parcel.writeParcelable(this.videoUri, i2);
    }

    protected StoryMessage(Parcel parcel) {
        this.imageUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.videoUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
