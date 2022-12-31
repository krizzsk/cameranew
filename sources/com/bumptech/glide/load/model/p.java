package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public abstract class p<T> implements k<Uri, T> {
    private final Context a;
    private final k<c, T> b;

    public p(Context context, k<c, T> kVar) {
        this.a = context;
        this.b = kVar;
    }

    private static boolean e(String str) {
        return "file".equals(str) || FirebaseAnalytics.Param.CONTENT.equals(str) || "android.resource".equals(str);
    }

    protected abstract com.bumptech.glide.load.g.c<T> b(Context context, String str);

    protected abstract com.bumptech.glide.load.g.c<T> c(Context context, Uri uri);

    @Override // com.bumptech.glide.load.model.k
    /* renamed from: d */
    public final com.bumptech.glide.load.g.c<T> a(Uri uri, int i2, int i3) {
        String scheme = uri.getScheme();
        if (e(scheme)) {
            if (a.a(uri)) {
                return b(this.a, a.b(uri));
            }
            return c(this.a, uri);
        } else if (this.b == null || !("http".equals(scheme) || "https".equals(scheme))) {
            return null;
        } else {
            return this.b.a(new c(uri.toString()), i2, i3);
        }
    }
}
