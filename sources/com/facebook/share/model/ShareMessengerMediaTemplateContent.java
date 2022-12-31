package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
@Deprecated
/* loaded from: classes.dex */
public final class ShareMessengerMediaTemplateContent extends ShareContent<ShareMessengerMediaTemplateContent, Object> {
    public static final Parcelable.Creator<ShareMessengerMediaTemplateContent> CREATOR = new a();
    private final String attachmentId;
    private final ShareMessengerActionButton button;
    private final MediaType mediaType;
    private final Uri mediaUrl;

    /* loaded from: classes.dex */
    public enum MediaType {
        IMAGE,
        VIDEO
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareMessengerMediaTemplateContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerMediaTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerMediaTemplateContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareMessengerMediaTemplateContent[] newArray(int i2) {
            return new ShareMessengerMediaTemplateContent[i2];
        }
    }

    ShareMessengerMediaTemplateContent(Parcel parcel) {
        super(parcel);
        this.mediaType = (MediaType) parcel.readSerializable();
        this.attachmentId = parcel.readString();
        this.mediaUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String k() {
        return this.attachmentId;
    }

    public ShareMessengerActionButton l() {
        return this.button;
    }

    public MediaType m() {
        return this.mediaType;
    }

    public Uri n() {
        return this.mediaUrl;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSerializable(this.mediaType);
        parcel.writeString(this.attachmentId);
        parcel.writeParcelable(this.mediaUrl, i2);
        parcel.writeParcelable(this.button, i2);
    }
}
