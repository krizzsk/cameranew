package com.bumptech.glide.load.engine;

import android.os.Looper;
import java.util.Objects;
/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class g<Z> implements i<Z> {
    private final i<Z> a;
    private final boolean b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.load.b f759d;

    /* renamed from: e  reason: collision with root package name */
    private int f760e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f761f;

    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    interface a {
        void d(com.bumptech.glide.load.b bVar, g<?> gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(i<Z> iVar, boolean z) {
        Objects.requireNonNull(iVar, "Wrapped resource must not be null");
        this.a = iVar;
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (!this.f761f) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                this.f760e++;
                return;
            }
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        throw new IllegalStateException("Cannot acquire a recycled resource");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f760e > 0) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                int i2 = this.f760e - 1;
                this.f760e = i2;
                if (i2 == 0) {
                    this.c.d(this.f759d, this);
                    return;
                }
                return;
            }
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(com.bumptech.glide.load.b bVar, a aVar) {
        this.f759d = bVar;
        this.c = aVar;
    }

    @Override // com.bumptech.glide.load.engine.i
    public Z get() {
        return this.a.get();
    }

    @Override // com.bumptech.glide.load.engine.i
    public int getSize() {
        return this.a.getSize();
    }

    @Override // com.bumptech.glide.load.engine.i
    public void recycle() {
        if (this.f760e <= 0) {
            if (!this.f761f) {
                this.f761f = true;
                this.a.recycle();
                return;
            }
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }
}
