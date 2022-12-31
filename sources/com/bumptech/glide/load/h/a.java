package com.bumptech.glide.load.h;

import java.io.OutputStream;
/* compiled from: NullEncoder.java */
/* loaded from: classes.dex */
public class a<T> implements com.bumptech.glide.load.a<T> {
    private static final a<?> a = new a<>();

    public static <T> com.bumptech.glide.load.a<T> b() {
        return a;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(T t, OutputStream outputStream) {
        return false;
    }

    @Override // com.bumptech.glide.load.a
    public String getId() {
        return "";
    }
}
