package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class SharePhotoContent extends ShareContent<SharePhotoContent, b> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new a();
    private final List<SharePhoto> photos;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<SharePhotoContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SharePhotoContent createFromParcel(Parcel parcel) {
            return new SharePhotoContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SharePhotoContent[] newArray(int i2) {
            return new SharePhotoContent[i2];
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ShareContent.a<SharePhotoContent, b> {

        /* renamed from: g  reason: collision with root package name */
        private final List<SharePhoto> f3241g = new ArrayList();

        public b o(@Nullable SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.f3241g.add(new SharePhoto.b().m(sharePhoto).i());
            }
            return this;
        }

        public b p(@Nullable List<SharePhoto> list) {
            if (list != null) {
                for (SharePhoto sharePhoto : list) {
                    o(sharePhoto);
                }
            }
            return this;
        }

        public SharePhotoContent q() {
            return new SharePhotoContent(this, null);
        }

        public b r(SharePhotoContent sharePhotoContent) {
            if (sharePhotoContent == null) {
                return this;
            }
            super.g(sharePhotoContent);
            b bVar = this;
            bVar.p(sharePhotoContent.k());
            return bVar;
        }

        public b s(@Nullable List<SharePhoto> list) {
            this.f3241g.clear();
            p(list);
            return this;
        }
    }

    /* synthetic */ SharePhotoContent(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public List<SharePhoto> k() {
        return this.photos;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        SharePhoto.b.s(parcel, i2, this.photos);
    }

    private SharePhotoContent(b bVar) {
        super(bVar);
        this.photos = Collections.unmodifiableList(bVar.f3241g);
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        this.photos = Collections.unmodifiableList(SharePhoto.b.n(parcel));
    }
}
