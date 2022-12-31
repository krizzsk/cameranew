package com.bumptech.glide.request.f;

import com.bumptech.glide.request.f.c;
/* compiled from: NoAnimation.java */
/* loaded from: classes.dex */
public class e<R> implements c<R> {
    private static final e<?> a = new e<>();
    private static final d<?> b = new a();

    /* compiled from: NoAnimation.java */
    /* loaded from: classes.dex */
    public static class a<R> implements d<R> {
        @Override // com.bumptech.glide.request.f.d
        public c<R> a(boolean z, boolean z2) {
            return e.a;
        }
    }

    public static <R> c<R> c() {
        return a;
    }

    public static <R> d<R> d() {
        return (d<R>) b;
    }

    @Override // com.bumptech.glide.request.f.c
    public boolean a(Object obj, c.a aVar) {
        return false;
    }
}
