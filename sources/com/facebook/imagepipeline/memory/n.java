package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
/* compiled from: DummyBitmapPool.java */
/* loaded from: classes.dex */
public class n implements d {
    @Override // com.facebook.common.memory.d
    /* renamed from: f */
    public Bitmap get(int i2) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.common.memory.d, com.facebook.common.references.h
    /* renamed from: g */
    public void release(Bitmap bitmap) {
        com.facebook.common.internal.h.g(bitmap);
        bitmap.recycle();
    }
}
