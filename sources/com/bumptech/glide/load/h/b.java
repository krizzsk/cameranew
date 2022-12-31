package com.bumptech.glide.load.h;

import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.i;
import java.io.OutputStream;
/* compiled from: NullResourceEncoder.java */
/* loaded from: classes.dex */
public class b<T> implements e<T> {
    private static final b<?> a = new b<>();

    public static <T> b<T> c() {
        return (b<T>) a;
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: b */
    public boolean a(i<T> iVar, OutputStream outputStream) {
        return false;
    }

    @Override // com.bumptech.glide.load.a
    public String getId() {
        return "";
    }
}
