package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DisplayBitmapTask.java */
/* loaded from: classes3.dex */
public final class b implements Runnable {
    private final Bitmap a;
    private final String b;
    private final com.nostra13.universalimageloader.core.j.a c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5928d;

    /* renamed from: e  reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.i.a f5929e;

    /* renamed from: f  reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.k.a f5930f;

    /* renamed from: g  reason: collision with root package name */
    private final d f5931g;

    /* renamed from: h  reason: collision with root package name */
    private final LoadedFrom f5932h;

    public b(Bitmap bitmap, f fVar, d dVar, LoadedFrom loadedFrom) {
        this.a = bitmap;
        this.b = fVar.a;
        this.c = fVar.c;
        this.f5928d = fVar.b;
        this.f5929e = fVar.f5959e.w();
        this.f5930f = fVar.f5960f;
        this.f5931g = dVar;
        this.f5932h = loadedFrom;
    }

    private boolean a() {
        return !this.f5928d.equals(this.f5931g.g(this.c));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.isCollected()) {
            d.f.a.b.d.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f5928d);
            this.f5930f.onLoadingCancelled(this.b, this.c.getWrappedView());
        } else if (a()) {
            d.f.a.b.d.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f5928d);
            this.f5930f.onLoadingCancelled(this.b, this.c.getWrappedView());
        } else {
            d.f.a.b.d.a("Display image in ImageAware (loaded from %1$s) [%2$s]", this.f5932h, this.f5928d);
            this.f5929e.display(this.a, this.c, this.f5932h);
            this.f5931g.d(this.c);
            this.f5930f.onLoadingComplete(this.b, this.c.getWrappedView(), this.a);
        }
    }
}
