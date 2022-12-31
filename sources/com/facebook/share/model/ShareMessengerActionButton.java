package com.facebook.share.model;

import android.os.Parcel;
@Deprecated
/* loaded from: classes.dex */
public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareMessengerActionButton(Parcel parcel) {
        this.title = parcel.readString();
    }

    public String a() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
    }
}
