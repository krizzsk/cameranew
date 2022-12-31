package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.engine.bitmap_recycle.c {

    /* renamed from: j  reason: collision with root package name */
    private static final Bitmap.Config f726j = Bitmap.Config.ARGB_8888;
    private final g a;
    private final Set<Bitmap.Config> b;
    private final b c;

    /* renamed from: d  reason: collision with root package name */
    private int f727d;

    /* renamed from: e  reason: collision with root package name */
    private int f728e;

    /* renamed from: f  reason: collision with root package name */
    private int f729f;

    /* renamed from: g  reason: collision with root package name */
    private int f730g;

    /* renamed from: h  reason: collision with root package name */
    private int f731h;

    /* renamed from: i  reason: collision with root package name */
    private int f732i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    private static class c implements b {
        private c() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f.b
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f.b
        public void b(Bitmap bitmap) {
        }
    }

    f(int i2, g gVar, Set<Bitmap.Config> set) {
        this.f727d = i2;
        this.a = gVar;
        this.b = set;
        this.c = new c();
    }

    private void f() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            g();
        }
    }

    private void g() {
        Log.v("LruBitmapPool", "Hits=" + this.f729f + ", misses=" + this.f730g + ", puts=" + this.f731h + ", evictions=" + this.f732i + ", currentSize=" + this.f728e + ", maxSize=" + this.f727d + "\nStrategy=" + this.a);
    }

    private void h() {
        k(this.f727d);
    }

    private static Set<Bitmap.Config> i() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static g j() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new i();
        }
        return new com.bumptech.glide.load.engine.bitmap_recycle.a();
    }

    private synchronized void k(int i2) {
        while (this.f728e > i2) {
            Bitmap removeLast = this.a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    g();
                }
                this.f728e = 0;
                return;
            }
            this.c.a(removeLast);
            this.f728e -= this.a.e(removeLast);
            removeLast.recycle();
            this.f732i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.a.b(removeLast));
            }
            f();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public synchronized boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.isMutable() && this.a.e(bitmap) <= this.f727d && this.b.contains(bitmap.getConfig())) {
                int e2 = this.a.e(bitmap);
                this.a.a(bitmap);
                this.c.b(bitmap);
                this.f731h++;
                this.f728e += e2;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.a.b(bitmap));
                }
                f();
                h();
                return true;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.a.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig()));
            }
            return false;
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @SuppressLint({"InlinedApi"})
    public void b(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 60) {
            c();
        } else if (i2 >= 40) {
            k(this.f727d / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public void c() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        k(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public synchronized Bitmap d(int i2, int i3, Bitmap.Config config) {
        Bitmap e2;
        e2 = e(i2, i3, config);
        if (e2 != null) {
            e2.eraseColor(0);
        }
        return e2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @TargetApi(12)
    public synchronized Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap d2;
        d2 = this.a.d(i2, i3, config != null ? config : f726j);
        if (d2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.a.c(i2, i3, config));
            }
            this.f730g++;
        } else {
            this.f729f++;
            this.f728e -= this.a.e(d2);
            this.c.a(d2);
            if (Build.VERSION.SDK_INT >= 12) {
                d2.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.a.c(i2, i3, config));
        }
        f();
        return d2;
    }

    public f(int i2) {
        this(i2, j(), i());
    }
}
