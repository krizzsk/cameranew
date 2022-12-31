package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ShareMedia implements ShareModel {
    private final Bundle params;

    /* loaded from: classes.dex */
    public enum Type {
        PHOTO,
        VIDEO
    }

    /* loaded from: classes.dex */
    public static abstract class a<M extends ShareMedia, B extends a> {
        private Bundle a = new Bundle();

        /* JADX INFO: Access modifiers changed from: package-private */
        public static List<ShareMedia> c(Parcel parcel) {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
            ArrayList arrayList = new ArrayList(readParcelableArray.length);
            for (Parcelable parcelable : readParcelableArray) {
                arrayList.add((ShareMedia) parcelable);
            }
            return arrayList;
        }

        public B b(M m) {
            if (m == null) {
                return this;
            }
            d(m.b());
            return this;
        }

        @Deprecated
        public B d(Bundle bundle) {
            this.a.putAll(bundle);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareMedia(a aVar) {
        this.params = new Bundle(aVar.a);
    }

    public abstract Type a();

    @Deprecated
    public Bundle b() {
        return new Bundle(this.params);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareMedia(Parcel parcel) {
        this.params = parcel.readBundle();
    }
}
