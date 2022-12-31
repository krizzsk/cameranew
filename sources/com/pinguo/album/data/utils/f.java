package com.pinguo.album.data.utils;

import android.graphics.Bitmap;
import android.util.SparseArray;
/* compiled from: SparseArrayBitmapPool.java */
/* loaded from: classes3.dex */
public class f {
    private int a;

    /* renamed from: d  reason: collision with root package name */
    private com.pinguo.album.j.d<a> f6031d;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f6034g;
    private SparseArray<a> b = new SparseArray<>();
    private int c = 0;

    /* renamed from: e  reason: collision with root package name */
    private a f6032e = null;

    /* renamed from: f  reason: collision with root package name */
    private a f6033f = null;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SparseArrayBitmapPool.java */
    /* loaded from: classes3.dex */
    public static class a {
        Bitmap a;
        a b;
        a c;

        /* renamed from: d  reason: collision with root package name */
        a f6035d;

        /* renamed from: e  reason: collision with root package name */
        a f6036e;

        protected a() {
        }
    }

    public f(int i2, com.pinguo.album.j.d<a> dVar, String str, boolean z) {
        this.a = i2;
        if (dVar == null) {
            this.f6031d = new com.pinguo.album.j.e(32);
        } else {
            this.f6031d = dVar;
        }
        this.f6034g = z;
    }

    private void b(int i2) {
        int i3 = this.a - i2;
        while (true) {
            a aVar = this.f6033f;
            if (aVar == null || this.c <= i3) {
                return;
            }
            f(aVar, true);
        }
    }

    private void f(a aVar, boolean z) {
        a aVar2 = aVar.b;
        if (aVar2 != null) {
            aVar2.c = aVar.c;
        } else {
            this.b.put(aVar.a.getWidth(), aVar.c);
        }
        a aVar3 = aVar.c;
        if (aVar3 != null) {
            aVar3.b = aVar.b;
        }
        a aVar4 = aVar.f6036e;
        if (aVar4 != null) {
            aVar4.f6035d = aVar.f6035d;
        } else {
            this.f6032e = aVar.f6035d;
        }
        a aVar5 = aVar.f6035d;
        if (aVar5 != null) {
            aVar5.f6036e = aVar4;
        } else {
            this.f6033f = aVar4;
        }
        aVar.c = null;
        aVar.f6035d = null;
        aVar.b = null;
        aVar.f6036e = null;
        this.c -= aVar.a.getRowBytes() * aVar.a.getHeight();
        if (z) {
            aVar.a.recycle();
        }
        aVar.a = null;
        this.f6031d.release(aVar);
    }

    public synchronized void a() {
        b(this.a);
    }

    public synchronized Bitmap c(int i2, int i3) {
        for (a aVar = this.b.get(i2); aVar != null; aVar = aVar.c) {
            if (aVar.a.getHeight() == i3) {
                Bitmap bitmap = aVar.a;
                f(aVar, false);
                return bitmap;
            }
        }
        return null;
    }

    public boolean d() {
        return this.f6034g;
    }

    public synchronized boolean e(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
        b(rowBytes);
        a acquire = this.f6031d.acquire();
        if (acquire == null) {
            acquire = new a();
        }
        acquire.a = bitmap;
        acquire.b = null;
        acquire.f6036e = null;
        acquire.f6035d = this.f6032e;
        this.f6032e = acquire;
        int width = bitmap.getWidth();
        a aVar = this.b.get(width);
        acquire.c = aVar;
        if (aVar != null) {
            aVar.b = acquire;
        }
        this.b.put(width, acquire);
        a aVar2 = acquire.f6035d;
        if (aVar2 == null) {
            this.f6033f = acquire;
        } else {
            aVar2.f6036e = acquire;
        }
        this.c += rowBytes;
        return true;
    }
}
