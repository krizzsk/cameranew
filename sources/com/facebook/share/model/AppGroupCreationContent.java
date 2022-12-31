package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class AppGroupCreationContent implements ShareModel {
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new a();
    private final String description;
    private final String name;
    private AppGroupPrivacy privacy;

    /* loaded from: classes.dex */
    public enum AppGroupPrivacy {
        Open,
        Closed
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<AppGroupCreationContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppGroupCreationContent createFromParcel(Parcel parcel) {
            return new AppGroupCreationContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AppGroupCreationContent[] newArray(int i2) {
            return new AppGroupCreationContent[i2];
        }
    }

    AppGroupCreationContent(Parcel parcel) {
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.privacy = (AppGroupPrivacy) parcel.readSerializable();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeSerializable(this.privacy);
    }
}
