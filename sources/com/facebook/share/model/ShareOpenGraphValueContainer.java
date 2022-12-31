package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.a;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends a> implements ShareModel {
    private final Bundle bundle;

    /* loaded from: classes.dex */
    public static abstract class a<P extends ShareOpenGraphValueContainer, E extends a> {
        private Bundle a = new Bundle();

        public E b(String str, @Nullable String str2) {
            this.a.putString(str, str2);
            return this;
        }

        public E c(P p) {
            if (p != null) {
                this.a.putAll(p.b());
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareOpenGraphValueContainer(a<P, E> aVar) {
        this.bundle = (Bundle) ((a) aVar).a.clone();
    }

    @Nullable
    public Object a(String str) {
        return this.bundle.get(str);
    }

    public Bundle b() {
        return (Bundle) this.bundle.clone();
    }

    @Nullable
    public String c(String str) {
        return this.bundle.getString(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Set<String> f() {
        return this.bundle.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareOpenGraphValueContainer(Parcel parcel) {
        this.bundle = parcel.readBundle(a.class.getClassLoader());
    }
}
