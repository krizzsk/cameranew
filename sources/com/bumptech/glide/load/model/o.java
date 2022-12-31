package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class o<T> implements k<String, T> {
    private final k<Uri, T> a;

    public o(k<Uri, T> kVar) {
        this.a = kVar;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.model.k
    /* renamed from: b */
    public com.bumptech.glide.load.g.c<T> a(String str, int i2, int i3) {
        Uri c;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            c = c(str);
        } else {
            Uri parse = Uri.parse(str);
            c = parse.getScheme() == null ? c(str) : parse;
        }
        return this.a.a(c, i2, i3);
    }
}
