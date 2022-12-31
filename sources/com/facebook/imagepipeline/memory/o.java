package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import java.util.Set;
/* compiled from: DummyTrackingInUseBitmapPool.java */
/* loaded from: classes.dex */
public class o implements d {
    private final Set<Bitmap> a = com.facebook.common.internal.j.b();

    @Override // com.facebook.common.memory.d
    /* renamed from: f */
    public Bitmap get(int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
        this.a.add(createBitmap);
        return createBitmap;
    }

    @Override // com.facebook.common.memory.d, com.facebook.common.references.h
    /* renamed from: g */
    public void release(Bitmap bitmap) {
        com.facebook.common.internal.h.g(bitmap);
        this.a.remove(bitmap);
        bitmap.recycle();
    }
}
