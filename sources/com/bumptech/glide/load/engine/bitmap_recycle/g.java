package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
/* compiled from: LruPoolStrategy.java */
/* loaded from: classes.dex */
interface g {
    void a(Bitmap bitmap);

    String b(Bitmap bitmap);

    String c(int i2, int i3, Bitmap.Config config);

    Bitmap d(int i2, int i3, Bitmap.Config config);

    int e(Bitmap bitmap);

    Bitmap removeLast();
}
