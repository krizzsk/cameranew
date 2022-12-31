package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: BitmapCounter.java */
/* loaded from: classes.dex */
public class b {
    @GuardedBy("this")
    private int a;
    @GuardedBy("this")
    private long b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2844d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.common.references.h<Bitmap> f2845e;

    /* compiled from: BitmapCounter.java */
    /* loaded from: classes.dex */
    class a implements com.facebook.common.references.h<Bitmap> {
        a() {
        }

        @Override // com.facebook.common.references.h
        /* renamed from: a */
        public void release(Bitmap bitmap) {
            try {
                b.this.a(bitmap);
            } finally {
                bitmap.recycle();
            }
        }
    }

    public b(int i2, int i3) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 > 0));
        com.facebook.common.internal.h.b(Boolean.valueOf(i3 > 0));
        this.c = i2;
        this.f2844d = i3;
        this.f2845e = new a();
    }

    public synchronized void a(Bitmap bitmap) {
        int e2 = com.facebook.imageutils.a.e(bitmap);
        com.facebook.common.internal.h.c(this.a > 0, "No bitmaps registered.");
        long j2 = e2;
        com.facebook.common.internal.h.d(j2 <= this.b, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(e2), Long.valueOf(this.b));
        this.b -= j2;
        this.a--;
    }

    public synchronized int b() {
        return this.a;
    }

    public synchronized int c() {
        return this.c;
    }

    public synchronized int d() {
        return this.f2844d;
    }

    public com.facebook.common.references.h<Bitmap> e() {
        return this.f2845e;
    }

    public synchronized long f() {
        return this.b;
    }

    public synchronized boolean g(Bitmap bitmap) {
        int e2 = com.facebook.imageutils.a.e(bitmap);
        int i2 = this.a;
        if (i2 < this.c) {
            long j2 = this.b;
            long j3 = e2;
            if (j2 + j3 <= this.f2844d) {
                this.a = i2 + 1;
                this.b = j2 + j3;
                return true;
            }
        }
        return false;
    }
}
