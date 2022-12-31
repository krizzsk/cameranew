package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Set;
/* loaded from: classes.dex */
public class CameraEffectTextures implements ShareModel {
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new a();
    private final Bundle textures;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<CameraEffectTextures> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CameraEffectTextures createFromParcel(Parcel parcel) {
            return new CameraEffectTextures(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CameraEffectTextures[] newArray(int i2) {
            return new CameraEffectTextures[i2];
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private Bundle a = new Bundle();

        public CameraEffectTextures b() {
            return new CameraEffectTextures(this, null);
        }

        public b c(Parcel parcel) {
            d((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
            return this;
        }

        public b d(CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.a.putAll(cameraEffectTextures.textures);
            }
            return this;
        }
    }

    /* synthetic */ CameraEffectTextures(b bVar, a aVar) {
        this(bVar);
    }

    @Nullable
    public Bitmap b(String str) {
        Object obj = this.textures.get(str);
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    @Nullable
    public Uri c(String str) {
        Object obj = this.textures.get(str);
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Set<String> f() {
        return this.textures.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.textures);
    }

    private CameraEffectTextures(b bVar) {
        this.textures = bVar.a;
    }

    CameraEffectTextures(Parcel parcel) {
        this.textures = parcel.readBundle(getClass().getClassLoader());
    }
}
