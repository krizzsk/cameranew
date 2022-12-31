package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
/* loaded from: classes.dex */
public final class ShareLinkContent extends ShareContent<ShareLinkContent, b> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new a();
    @Deprecated
    private final String contentDescription;
    @Deprecated
    private final String contentTitle;
    @Deprecated
    private final Uri imageUrl;
    private final String quote;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareLinkContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareLinkContent[] newArray(int i2) {
            return new ShareLinkContent[i2];
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends ShareContent.a<ShareLinkContent, b> {
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        private String f3235g;
        @Deprecated

        /* renamed from: h  reason: collision with root package name */
        private String f3236h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        private Uri f3237i;

        /* renamed from: j  reason: collision with root package name */
        private String f3238j;

        public ShareLinkContent r() {
            return new ShareLinkContent(this, null);
        }

        public b s(@Nullable String str) {
            this.f3238j = str;
            return this;
        }
    }

    /* synthetic */ ShareLinkContent(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String k() {
        return this.contentDescription;
    }

    @Nullable
    @Deprecated
    public String l() {
        return this.contentTitle;
    }

    @Nullable
    @Deprecated
    public Uri m() {
        return this.imageUrl;
    }

    @Nullable
    public String n() {
        return this.quote;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeString(this.quote);
    }

    private ShareLinkContent(b bVar) {
        super(bVar);
        this.contentDescription = bVar.f3235g;
        this.contentTitle = bVar.f3236h;
        this.imageUrl = bVar.f3237i;
        this.quote = bVar.f3238j;
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.quote = parcel.readString();
    }
}
