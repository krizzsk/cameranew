package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: BucketsBitmapPool.java */
@ThreadSafe
@TargetApi(21)
/* loaded from: classes.dex */
public class h extends BasePool<Bitmap> implements d {
    public h(com.facebook.common.memory.c cVar, c0 c0Var, d0 d0Var, boolean z) {
        super(cVar, c0Var, d0Var, z);
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: A */
    public void j(Bitmap bitmap) {
        com.facebook.common.internal.h.g(bitmap);
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: B */
    public int n(Bitmap bitmap) {
        com.facebook.common.internal.h.g(bitmap);
        return bitmap.getAllocationByteCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    @Nullable
    /* renamed from: C */
    public Bitmap p(f<Bitmap> fVar) {
        Bitmap bitmap = (Bitmap) super.p(fVar);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: D */
    public boolean t(Bitmap bitmap) {
        com.facebook.common.internal.h.g(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int m(int i2) {
        return i2;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int o(int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: z */
    public Bitmap f(int i2) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
    }
}
