package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new a();
    private final String hashtag;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareHashtag> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareHashtag createFromParcel(Parcel parcel) {
            return new ShareHashtag(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareHashtag[] newArray(int i2) {
            return new ShareHashtag[i2];
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private String a;

        public ShareHashtag b() {
            return new ShareHashtag(this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b c(Parcel parcel) {
            d((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
            return this;
        }

        public b d(ShareHashtag shareHashtag) {
            if (shareHashtag == null) {
                return this;
            }
            e(shareHashtag.a());
            return this;
        }

        public b e(String str) {
            this.a = str;
            return this;
        }
    }

    /* synthetic */ ShareHashtag(b bVar, a aVar) {
        this(bVar);
    }

    public String a() {
        return this.hashtag;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.hashtag);
    }

    private ShareHashtag(b bVar) {
        this.hashtag = bVar.a;
    }

    ShareHashtag(Parcel parcel) {
        this.hashtag = parcel.readString();
    }
}
