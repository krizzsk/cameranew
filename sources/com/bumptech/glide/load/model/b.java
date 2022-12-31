package com.bumptech.glide.load.model;

import android.net.Uri;
import java.io.File;
/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class b<T> implements k<File, T> {
    private final k<Uri, T> a;

    public b(k<Uri, T> kVar) {
        this.a = kVar;
    }

    @Override // com.bumptech.glide.load.model.k
    /* renamed from: b */
    public com.bumptech.glide.load.g.c<T> a(File file, int i2, int i3) {
        return this.a.a(Uri.fromFile(file), i2, i3);
    }
}
