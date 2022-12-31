package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
@Deprecated
/* loaded from: classes.dex */
public class LikeContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<LikeContent> CREATOR = new a();
    private final String objectId;
    private final String objectType;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<LikeContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LikeContent createFromParcel(Parcel parcel) {
            return new LikeContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LikeContent[] newArray(int i2) {
            return new LikeContent[i2];
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class b {
        private String a;
        private String b;

        @Deprecated
        public LikeContent c() {
            return new LikeContent(this, null);
        }

        @Deprecated
        public b d(String str) {
            this.a = str;
            return this;
        }

        @Deprecated
        public b e(String str) {
            this.b = str;
            return this;
        }
    }

    /* synthetic */ LikeContent(b bVar, a aVar) {
        this(bVar);
    }

    @Deprecated
    public String a() {
        return this.objectId;
    }

    @Deprecated
    public String b() {
        return this.objectType;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.objectId);
        parcel.writeString(this.objectType);
    }

    private LikeContent(b bVar) {
        this.objectId = bVar.a;
        this.objectType = bVar.b;
    }

    @Deprecated
    LikeContent(Parcel parcel) {
        this.objectId = parcel.readString();
        this.objectType = parcel.readString();
    }
}
