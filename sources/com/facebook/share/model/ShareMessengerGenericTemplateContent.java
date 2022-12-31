package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
@Deprecated
/* loaded from: classes.dex */
public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Object> {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateContent> CREATOR = new a();
    private final ShareMessengerGenericTemplateElement genericTemplateElement;
    private final ImageAspectRatio imageAspectRatio;
    private final boolean isSharable;

    /* loaded from: classes.dex */
    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareMessengerGenericTemplateContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareMessengerGenericTemplateContent[] newArray(int i2) {
            return new ShareMessengerGenericTemplateContent[i2];
        }
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        this.isSharable = parcel.readByte() != 0;
        this.imageAspectRatio = (ImageAspectRatio) parcel.readSerializable();
        this.genericTemplateElement = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ShareMessengerGenericTemplateElement k() {
        return this.genericTemplateElement;
    }

    public ImageAspectRatio l() {
        return this.imageAspectRatio;
    }

    public boolean m() {
        return this.isSharable;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.isSharable ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.imageAspectRatio);
        parcel.writeParcelable(this.genericTemplateElement, i2);
    }
}
