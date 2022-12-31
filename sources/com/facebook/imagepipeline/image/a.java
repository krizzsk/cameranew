package com.facebook.imagepipeline.image;

import javax.annotation.Nullable;
/* compiled from: CloseableAnimatedImage.java */
/* loaded from: classes.dex */
public class a extends c {
    @Nullable
    private com.facebook.imagepipeline.animated.base.d c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2804d;

    public a(com.facebook.imagepipeline.animated.base.d dVar) {
        this(dVar, true);
    }

    @Override // com.facebook.imagepipeline.image.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            com.facebook.imagepipeline.animated.base.d dVar = this.c;
            if (dVar == null) {
                return;
            }
            this.c = null;
            dVar.a();
        }
    }

    @Override // com.facebook.imagepipeline.image.g
    public synchronized int getHeight() {
        com.facebook.imagepipeline.animated.base.d dVar;
        dVar = this.c;
        return dVar == null ? 0 : dVar.d().getHeight();
    }

    @Override // com.facebook.imagepipeline.image.g
    public synchronized int getWidth() {
        com.facebook.imagepipeline.animated.base.d dVar;
        dVar = this.c;
        return dVar == null ? 0 : dVar.d().getWidth();
    }

    @Override // com.facebook.imagepipeline.image.c
    public synchronized boolean isClosed() {
        return this.c == null;
    }

    @Override // com.facebook.imagepipeline.image.c
    public synchronized int t() {
        com.facebook.imagepipeline.animated.base.d dVar;
        dVar = this.c;
        return dVar == null ? 0 : dVar.d().g();
    }

    @Override // com.facebook.imagepipeline.image.c
    public boolean v() {
        return this.f2804d;
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.animated.base.b y() {
        com.facebook.imagepipeline.animated.base.d dVar;
        dVar = this.c;
        return dVar == null ? null : dVar.d();
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.animated.base.d z() {
        return this.c;
    }

    public a(com.facebook.imagepipeline.animated.base.d dVar, boolean z) {
        this.c = dVar;
        this.f2804d = z;
    }
}
