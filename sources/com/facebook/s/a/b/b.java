package com.facebook.s.a.b;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* compiled from: BitmapFrameCache.java */
/* loaded from: classes.dex */
public interface b {

    /* compiled from: BitmapFrameCache.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar, int i2);

        void b(b bVar, int i2);
    }

    void a(int i2, com.facebook.common.references.a<Bitmap> aVar, int i3);

    void b(int i2, com.facebook.common.references.a<Bitmap> aVar, int i3);

    @Nullable
    com.facebook.common.references.a<Bitmap> c(int i2);

    void clear();

    @Nullable
    com.facebook.common.references.a<Bitmap> d(int i2, int i3, int i4);

    boolean e(int i2);

    @Nullable
    com.facebook.common.references.a<Bitmap> f(int i2);
}
