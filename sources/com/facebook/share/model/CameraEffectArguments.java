package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Set;
/* loaded from: classes.dex */
public class CameraEffectArguments implements ShareModel {
    public static final Parcelable.Creator<CameraEffectArguments> CREATOR = new a();
    private final Bundle params;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<CameraEffectArguments> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CameraEffectArguments createFromParcel(Parcel parcel) {
            return new CameraEffectArguments(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CameraEffectArguments[] newArray(int i2) {
            return new CameraEffectArguments[i2];
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private Bundle a = new Bundle();

        public CameraEffectArguments b() {
            return new CameraEffectArguments(this, null);
        }

        public b c(Parcel parcel) {
            d((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
            return this;
        }

        public b d(CameraEffectArguments cameraEffectArguments) {
            if (cameraEffectArguments != null) {
                this.a.putAll(cameraEffectArguments.params);
            }
            return this;
        }
    }

    /* synthetic */ CameraEffectArguments(b bVar, a aVar) {
        this(bVar);
    }

    @Nullable
    public Object b(String str) {
        return this.params.get(str);
    }

    public Set<String> c() {
        return this.params.keySet();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.params);
    }

    private CameraEffectArguments(b bVar) {
        this.params = bVar.a;
    }

    CameraEffectArguments(Parcel parcel) {
        this.params = parcel.readBundle(getClass().getClassLoader());
    }
}
