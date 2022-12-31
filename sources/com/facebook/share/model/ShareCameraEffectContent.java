package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;
/* loaded from: classes.dex */
public class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Object> {
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new a();
    private CameraEffectArguments arguments;
    private String effectId;
    private CameraEffectTextures textures;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareCameraEffectContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareCameraEffectContent createFromParcel(Parcel parcel) {
            return new ShareCameraEffectContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareCameraEffectContent[] newArray(int i2) {
            return new ShareCameraEffectContent[i2];
        }
    }

    ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        this.effectId = parcel.readString();
        CameraEffectArguments.b bVar = new CameraEffectArguments.b();
        bVar.c(parcel);
        this.arguments = bVar.b();
        CameraEffectTextures.b bVar2 = new CameraEffectTextures.b();
        bVar2.c(parcel);
        this.textures = bVar2.b();
    }

    public CameraEffectArguments k() {
        return this.arguments;
    }

    public String l() {
        return this.effectId;
    }

    public CameraEffectTextures m() {
        return this.textures;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.effectId);
        parcel.writeParcelable(this.arguments, 0);
        parcel.writeParcelable(this.textures, 0);
    }
}
