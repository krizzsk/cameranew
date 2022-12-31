package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: CloseableStaticBitmap.java */
@ThreadSafe
/* loaded from: classes.dex */
public class d extends b implements com.facebook.common.references.d {
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Bitmap f2805d;

    /* renamed from: e  reason: collision with root package name */
    private final i f2806e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2807f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2808g;

    public d(Bitmap bitmap, com.facebook.common.references.h<Bitmap> hVar, i iVar, int i2) {
        this(bitmap, hVar, iVar, i2, 0);
    }

    private synchronized com.facebook.common.references.a<Bitmap> A() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.c;
        this.c = null;
        this.f2805d = null;
        return aVar;
    }

    private static int N(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    private static int O(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public int Q() {
        return this.f2808g;
    }

    public int R() {
        return this.f2807f;
    }

    @Override // com.facebook.imagepipeline.image.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> A = A();
        if (A != null) {
            A.close();
        }
    }

    @Override // com.facebook.imagepipeline.image.c
    public i d() {
        return this.f2806e;
    }

    @Override // com.facebook.imagepipeline.image.g
    public int getHeight() {
        int i2;
        if (this.f2807f % BaseBlurEffect.ROTATION_180 == 0 && (i2 = this.f2808g) != 5 && i2 != 7) {
            return N(this.f2805d);
        }
        return O(this.f2805d);
    }

    @Override // com.facebook.imagepipeline.image.g
    public int getWidth() {
        int i2;
        if (this.f2807f % BaseBlurEffect.ROTATION_180 == 0 && (i2 = this.f2808g) != 5 && i2 != 7) {
            return O(this.f2805d);
        }
        return N(this.f2805d);
    }

    @Override // com.facebook.imagepipeline.image.c
    public synchronized boolean isClosed() {
        return this.c == null;
    }

    @Override // com.facebook.imagepipeline.image.c
    public int t() {
        return com.facebook.imageutils.a.e(this.f2805d);
    }

    @Override // com.facebook.imagepipeline.image.b
    public Bitmap y() {
        return this.f2805d;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> z() {
        return com.facebook.common.references.a.w(this.c);
    }

    public d(Bitmap bitmap, com.facebook.common.references.h<Bitmap> hVar, i iVar, int i2, int i3) {
        com.facebook.common.internal.h.g(bitmap);
        this.f2805d = bitmap;
        Bitmap bitmap2 = this.f2805d;
        com.facebook.common.internal.h.g(hVar);
        this.c = com.facebook.common.references.a.T(bitmap2, hVar);
        this.f2806e = iVar;
        this.f2807f = i2;
        this.f2808g = i3;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, i iVar, int i2) {
        this(aVar, iVar, i2, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, i iVar, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> v = aVar.v();
        com.facebook.common.internal.h.g(v);
        com.facebook.common.references.a<Bitmap> aVar2 = v;
        this.c = aVar2;
        this.f2805d = aVar2.A();
        this.f2806e = iVar;
        this.f2807f = i2;
        this.f2808g = i3;
    }
}
