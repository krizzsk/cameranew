package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import javax.annotation.Nullable;
/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class r implements d {
    protected final z<Bitmap> a = new e();
    private final int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private final d0 f2858d;

    /* renamed from: e  reason: collision with root package name */
    private int f2859e;

    public r(int i2, int i3, d0 d0Var, @Nullable com.facebook.common.memory.c cVar) {
        this.b = i2;
        this.c = i3;
        this.f2858d = d0Var;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @VisibleForTesting
    private Bitmap f(int i2) {
        this.f2858d.d(i2);
        return Bitmap.createBitmap(1, i2, Bitmap.Config.ALPHA_8);
    }

    private synchronized void i(int i2) {
        Bitmap pop;
        while (this.f2859e > i2 && (pop = this.a.pop()) != null) {
            int a = this.a.a(pop);
            this.f2859e -= a;
            this.f2858d.b(a);
        }
    }

    @Override // com.facebook.common.memory.d
    /* renamed from: g */
    public synchronized Bitmap get(int i2) {
        int i3 = this.f2859e;
        int i4 = this.b;
        if (i3 > i4) {
            i(i4);
        }
        Bitmap bitmap = this.a.get(i2);
        if (bitmap != null) {
            int a = this.a.a(bitmap);
            this.f2859e -= a;
            this.f2858d.e(a);
            return bitmap;
        }
        return f(i2);
    }

    @Override // com.facebook.common.memory.d, com.facebook.common.references.h
    /* renamed from: h */
    public void release(Bitmap bitmap) {
        int a = this.a.a(bitmap);
        if (a <= this.c) {
            this.f2858d.c(a);
            this.a.put(bitmap);
            synchronized (this) {
                this.f2859e += a;
            }
        }
    }
}
