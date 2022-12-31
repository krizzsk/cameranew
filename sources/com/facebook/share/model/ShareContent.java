package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.a;
import com.facebook.share.model.ShareHashtag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ShareContent<P extends ShareContent, E extends a> implements ShareModel {
    private final Uri contentUrl;
    private final ShareHashtag hashtag;
    private final String pageId;
    private final List<String> peopleIds;
    private final String placeId;
    private final String ref;

    /* loaded from: classes.dex */
    public static abstract class a<P extends ShareContent, E extends a> {
        private Uri a;
        private List<String> b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private String f3232d;

        /* renamed from: e  reason: collision with root package name */
        private String f3233e;

        /* renamed from: f  reason: collision with root package name */
        private ShareHashtag f3234f;

        public E g(P p) {
            if (p == null) {
                return this;
            }
            h(p.a());
            j(p.c());
            k(p.f());
            i(p.b());
            l(p.g());
            m(p.h());
            return this;
        }

        public E h(@Nullable Uri uri) {
            this.a = uri;
            return this;
        }

        public E i(@Nullable String str) {
            this.f3232d = str;
            return this;
        }

        public E j(@Nullable List<String> list) {
            this.b = list == null ? null : Collections.unmodifiableList(list);
            return this;
        }

        public E k(@Nullable String str) {
            this.c = str;
            return this;
        }

        public E l(@Nullable String str) {
            this.f3233e = str;
            return this;
        }

        public E m(@Nullable ShareHashtag shareHashtag) {
            this.f3234f = shareHashtag;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareContent(a aVar) {
        this.contentUrl = aVar.a;
        this.peopleIds = aVar.b;
        this.placeId = aVar.c;
        this.pageId = aVar.f3232d;
        this.ref = aVar.f3233e;
        this.hashtag = aVar.f3234f;
    }

    private List<String> j(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.size() == 0) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    public Uri a() {
        return this.contentUrl;
    }

    @Nullable
    public String b() {
        return this.pageId;
    }

    @Nullable
    public List<String> c() {
        return this.peopleIds;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String f() {
        return this.placeId;
    }

    @Nullable
    public String g() {
        return this.ref;
    }

    @Nullable
    public ShareHashtag h() {
        return this.hashtag;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.contentUrl, 0);
        parcel.writeStringList(this.peopleIds);
        parcel.writeString(this.placeId);
        parcel.writeString(this.pageId);
        parcel.writeString(this.ref);
        parcel.writeParcelable(this.hashtag, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareContent(Parcel parcel) {
        this.contentUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.peopleIds = j(parcel);
        this.placeId = parcel.readString();
        this.pageId = parcel.readString();
        this.ref = parcel.readString();
        ShareHashtag.b bVar = new ShareHashtag.b();
        bVar.c(parcel);
        this.hashtag = bVar.b();
    }
}
