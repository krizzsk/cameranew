package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareMedia;
/* loaded from: classes.dex */
public final class ShareVideo extends ShareMedia {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new a();
    private final Uri localUrl;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareVideo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareVideo createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareVideo[] newArray(int i2) {
            return new ShareVideo[i2];
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends ShareMedia.a<ShareVideo, b> {
        private Uri b;

        public ShareVideo f() {
            return new ShareVideo(this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b g(Parcel parcel) {
            return h((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }

        public b h(ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            super.b(shareVideo);
            b bVar = this;
            bVar.i(shareVideo.c());
            return bVar;
        }

        public b i(@Nullable Uri uri) {
            this.b = uri;
            return this;
        }
    }

    /* synthetic */ ShareVideo(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.facebook.share.model.ShareMedia
    public ShareMedia.Type a() {
        return ShareMedia.Type.VIDEO;
    }

    @Nullable
    public Uri c() {
        return this.localUrl;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.localUrl, 0);
    }

    private ShareVideo(b bVar) {
        super(bVar);
        this.localUrl = bVar.b;
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
