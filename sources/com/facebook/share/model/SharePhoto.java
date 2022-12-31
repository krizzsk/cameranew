package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class SharePhoto extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new a();
    private final Bitmap bitmap;
    private final String caption;
    private final Uri imageUrl;
    private final boolean userGenerated;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<SharePhoto> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SharePhoto createFromParcel(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SharePhoto[] newArray(int i2) {
            return new SharePhoto[i2];
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends ShareMedia.a<SharePhoto, b> {
        private Bitmap b;
        private Uri c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3239d;

        /* renamed from: e  reason: collision with root package name */
        private String f3240e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static List<SharePhoto> n(Parcel parcel) {
            List<ShareMedia> c = ShareMedia.a.c(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia shareMedia : c) {
                if (shareMedia instanceof SharePhoto) {
                    arrayList.add((SharePhoto) shareMedia);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void s(Parcel parcel, int i2, List<SharePhoto> list) {
            ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                shareMediaArr[i3] = list.get(i3);
            }
            parcel.writeParcelableArray(shareMediaArr, i2);
        }

        public SharePhoto i() {
            return new SharePhoto(this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bitmap j() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Uri k() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b l(Parcel parcel) {
            return m((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        public b m(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                return this;
            }
            super.b(sharePhoto);
            b bVar = this;
            bVar.o(sharePhoto.c());
            bVar.q(sharePhoto.g());
            bVar.r(sharePhoto.h());
            bVar.p(sharePhoto.f());
            return bVar;
        }

        public b o(@Nullable Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public b p(@Nullable String str) {
            this.f3240e = str;
            return this;
        }

        public b q(@Nullable Uri uri) {
            this.c = uri;
            return this;
        }

        public b r(boolean z) {
            this.f3239d = z;
            return this;
        }
    }

    /* synthetic */ SharePhoto(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.facebook.share.model.ShareMedia
    public ShareMedia.Type a() {
        return ShareMedia.Type.PHOTO;
    }

    @Nullable
    public Bitmap c() {
        return this.bitmap;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String f() {
        return this.caption;
    }

    @Nullable
    public Uri g() {
        return this.imageUrl;
    }

    public boolean h() {
        return this.userGenerated;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeByte(this.userGenerated ? (byte) 1 : (byte) 0);
        parcel.writeString(this.caption);
    }

    private SharePhoto(b bVar) {
        super(bVar);
        this.bitmap = bVar.b;
        this.imageUrl = bVar.c;
        this.userGenerated = bVar.f3239d;
        this.caption = bVar.f3240e;
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != 0;
        this.caption = parcel.readString();
    }
}
