package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
@Deprecated
/* loaded from: classes.dex */
public final class ShareMessengerGenericTemplateElement implements ShareModel {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateElement> CREATOR = new a();
    private final ShareMessengerActionButton button;
    private final ShareMessengerActionButton defaultAction;
    private final Uri imageUrl;
    private final String subtitle;
    private final String title;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareMessengerGenericTemplateElement> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerGenericTemplateElement createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareMessengerGenericTemplateElement[] newArray(int i2) {
            return new ShareMessengerGenericTemplateElement[i2];
        }
    }

    ShareMessengerGenericTemplateElement(Parcel parcel) {
        this.title = parcel.readString();
        this.subtitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.defaultAction = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    public ShareMessengerActionButton a() {
        return this.button;
    }

    public ShareMessengerActionButton b() {
        return this.defaultAction;
    }

    public Uri c() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String f() {
        return this.subtitle;
    }

    public String g() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.imageUrl, i2);
        parcel.writeParcelable(this.defaultAction, i2);
        parcel.writeParcelable(this.button, i2);
    }
}
