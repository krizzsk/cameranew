package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
/* loaded from: classes.dex */
public class ShareFeedContent extends ShareContent<ShareFeedContent, Object> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new a();
    private final String link;
    private final String linkCaption;
    private final String linkDescription;
    private final String linkName;
    private final String mediaSource;
    private final String picture;
    private final String toId;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareFeedContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareFeedContent createFromParcel(Parcel parcel) {
            return new ShareFeedContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareFeedContent[] newArray(int i2) {
            return new ShareFeedContent[i2];
        }
    }

    ShareFeedContent(Parcel parcel) {
        super(parcel);
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String k() {
        return this.link;
    }

    public String l() {
        return this.linkCaption;
    }

    public String m() {
        return this.linkDescription;
    }

    public String n() {
        return this.linkName;
    }

    public String o() {
        return this.mediaSource;
    }

    public String p() {
        return this.picture;
    }

    public String q() {
        return this.toId;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.toId);
        parcel.writeString(this.link);
        parcel.writeString(this.linkName);
        parcel.writeString(this.linkCaption);
        parcel.writeString(this.linkDescription);
        parcel.writeString(this.picture);
        parcel.writeString(this.mediaSource);
    }
}
