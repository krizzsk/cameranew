package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
@Deprecated
/* loaded from: classes.dex */
public final class AppInviteContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<AppInviteContent> CREATOR = new a();
    private final String applinkUrl;
    private final AppInviteContent$Builder$Destination destination;
    private final String previewImageUrl;
    private final String promoCode;
    private final String promoText;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<AppInviteContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppInviteContent createFromParcel(Parcel parcel) {
            return new AppInviteContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AppInviteContent[] newArray(int i2) {
            return new AppInviteContent[i2];
        }
    }

    @Deprecated
    AppInviteContent(Parcel parcel) {
        this.applinkUrl = parcel.readString();
        this.previewImageUrl = parcel.readString();
        this.promoText = parcel.readString();
        this.promoCode = parcel.readString();
        String readString = parcel.readString();
        if (readString.length() > 0) {
            this.destination = AppInviteContent$Builder$Destination.valueOf(readString);
        } else {
            this.destination = AppInviteContent$Builder$Destination.FACEBOOK;
        }
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.applinkUrl);
        parcel.writeString(this.previewImageUrl);
        parcel.writeString(this.promoText);
        parcel.writeString(this.promoCode);
        parcel.writeString(this.destination.toString());
    }
}
