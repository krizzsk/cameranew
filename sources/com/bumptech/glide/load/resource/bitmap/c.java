package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.util.Objects;
/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.engine.i<Bitmap> {
    private final Bitmap a;
    private final com.bumptech.glide.load.engine.bitmap_recycle.c b;

    public c(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        Objects.requireNonNull(cVar, "BitmapPool must not be null");
        this.a = bitmap;
        this.b = cVar;
    }

    public static c b(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, cVar);
    }

    @Override // com.bumptech.glide.load.engine.i
    /* renamed from: a */
    public Bitmap get() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.i
    public int getSize() {
        return com.bumptech.glide.l.h.e(this.a);
    }

    @Override // com.bumptech.glide.load.engine.i
    public void recycle() {
        if (this.b.a(this.a)) {
            return;
        }
        this.a.recycle();
    }
}
