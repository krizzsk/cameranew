package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
/* loaded from: classes.dex */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, b> implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new a();
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareVideoContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareVideoContent createFromParcel(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareVideoContent[] newArray(int i2) {
            return new ShareVideoContent[i2];
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends ShareContent.a<ShareVideoContent, b> {

        /* renamed from: g  reason: collision with root package name */
        private String f3242g;

        /* renamed from: h  reason: collision with root package name */
        private String f3243h;

        /* renamed from: i  reason: collision with root package name */
        private SharePhoto f3244i;

        /* renamed from: j  reason: collision with root package name */
        private ShareVideo f3245j;

        public ShareVideoContent r() {
            return new ShareVideoContent(this, null);
        }

        public b s(@Nullable String str) {
            this.f3242g = str;
            return this;
        }

        public b t(@Nullable String str) {
            this.f3243h = str;
            return this;
        }

        public b u(@Nullable SharePhoto sharePhoto) {
            this.f3244i = sharePhoto == null ? null : new SharePhoto.b().m(sharePhoto).i();
            return this;
        }

        public b v(@Nullable ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            this.f3245j = new ShareVideo.b().h(shareVideo).f();
            return this;
        }
    }

    /* synthetic */ ShareVideoContent(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String k() {
        return this.contentDescription;
    }

    @Nullable
    public String l() {
        return this.contentTitle;
    }

    @Nullable
    public SharePhoto m() {
        return this.previewPhoto;
    }

    @Nullable
    public ShareVideo n() {
        return this.video;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.previewPhoto, 0);
        parcel.writeParcelable(this.video, 0);
    }

    private ShareVideoContent(b bVar) {
        super(bVar);
        this.contentDescription = bVar.f3242g;
        this.contentTitle = bVar.f3243h;
        this.previewPhoto = bVar.f3244i;
        this.video = bVar.f3245j;
    }

    ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        SharePhoto.b l2 = new SharePhoto.b().l(parcel);
        if (l2.k() == null && l2.j() == null) {
            this.previewPhoto = null;
        } else {
            this.previewPhoto = l2.i();
        }
        this.video = new ShareVideo.b().g(parcel).f();
    }
}
