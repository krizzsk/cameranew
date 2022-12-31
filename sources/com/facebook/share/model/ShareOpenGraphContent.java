package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphAction;
/* loaded from: classes.dex */
public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Object> {
    public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new a();
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareOpenGraphContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareOpenGraphContent[] newArray(int i2) {
            return new ShareOpenGraphContent[i2];
        }
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.action = new ShareOpenGraphAction.b().e(parcel).d();
        this.previewPropertyName = parcel.readString();
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public ShareOpenGraphAction k() {
        return this.action;
    }

    @Nullable
    public String l() {
        return this.previewPropertyName;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
    }
}
