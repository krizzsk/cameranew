package com.bumptech.glide.load.model;

import java.net.URL;
/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class q<T> implements k<URL, T> {
    private final k<c, T> a;

    public q(k<c, T> kVar) {
        this.a = kVar;
    }

    @Override // com.bumptech.glide.load.model.k
    /* renamed from: b */
    public com.bumptech.glide.load.g.c<T> a(URL url, int i2, int i3) {
        return this.a.a(new c(url), i2, i3);
    }
}
