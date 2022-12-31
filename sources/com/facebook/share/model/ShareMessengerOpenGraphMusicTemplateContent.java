package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
@Deprecated
/* loaded from: classes.dex */
public final class ShareMessengerOpenGraphMusicTemplateContent extends ShareContent<ShareMessengerOpenGraphMusicTemplateContent, Object> {
    public static final Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent> CREATOR = new a();
    private final ShareMessengerActionButton button;
    private final Uri url;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerOpenGraphMusicTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerOpenGraphMusicTemplateContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareMessengerOpenGraphMusicTemplateContent[] newArray(int i2) {
            return new ShareMessengerOpenGraphMusicTemplateContent[i2];
        }
    }

    ShareMessengerOpenGraphMusicTemplateContent(Parcel parcel) {
        super(parcel);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ShareMessengerActionButton k() {
        return this.button;
    }

    public Uri l() {
        return this.url;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.url, i2);
        parcel.writeParcelable(this.button, i2);
    }
}
