package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class ShareStoryContent extends ShareContent<ShareStoryContent, Object> {
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new a();
    private final String mAttributionLink;
    private final ShareMedia mBackgroundAsset;
    @Nullable
    private final List<String> mBackgroundColorList;
    private final SharePhoto mStickerAsset;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareStoryContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareStoryContent createFromParcel(Parcel parcel) {
            return new ShareStoryContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareStoryContent[] newArray(int i2) {
            return new ShareStoryContent[i2];
        }
    }

    ShareStoryContent(Parcel parcel) {
        super(parcel);
        this.mBackgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.mStickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.mBackgroundColorList = j(parcel);
        this.mAttributionLink = parcel.readString();
    }

    @Nullable
    private List<String> j(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String k() {
        return this.mAttributionLink;
    }

    public ShareMedia l() {
        return this.mBackgroundAsset;
    }

    @Nullable
    public List<String> m() {
        List<String> list = this.mBackgroundColorList;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public SharePhoto n() {
        return this.mStickerAsset;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.mBackgroundAsset, 0);
        parcel.writeParcelable(this.mStickerAsset, 0);
        parcel.writeStringList(this.mBackgroundColorList);
        parcel.writeString(this.mAttributionLink);
    }
}
