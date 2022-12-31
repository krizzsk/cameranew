package com.bumptech.glide.load.h.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.i;
import java.util.Objects;
/* compiled from: GifBitmapWrapperResource.java */
/* loaded from: classes.dex */
public class b implements i<a> {
    private final a a;

    public b(a aVar) {
        Objects.requireNonNull(aVar, "Data must not be null");
        this.a = aVar;
    }

    @Override // com.bumptech.glide.load.engine.i
    /* renamed from: a */
    public a get() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.i
    public int getSize() {
        return this.a.c();
    }

    @Override // com.bumptech.glide.load.engine.i
    public void recycle() {
        i<Bitmap> a = this.a.a();
        if (a != null) {
            a.recycle();
        }
        i<com.bumptech.glide.load.resource.gif.b> b = this.a.b();
        if (b != null) {
            b.recycle();
        }
    }
}
