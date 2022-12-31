package com.hw.photomovie.render;

import android.graphics.Rect;
import com.hw.photomovie.a;
import com.hw.photomovie.segment.e;
/* compiled from: MovieRenderer.java */
/* loaded from: classes2.dex */
public abstract class d<T> {
    protected com.hw.photomovie.a<T> a;
    protected volatile int b;

    /* renamed from: d  reason: collision with root package name */
    protected T f5214d;

    /* renamed from: f  reason: collision with root package name */
    protected a f5216f;

    /* renamed from: g  reason: collision with root package name */
    protected e<T> f5217g;
    protected Rect c = new Rect();

    /* renamed from: e  reason: collision with root package name */
    protected boolean f5215e = true;

    /* compiled from: MovieRenderer.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public abstract void a(int i2);

    public void b(int i2) {
        a.b g2;
        e<T> e2;
        e<T> c;
        com.hw.photomovie.a<T> aVar = this.a;
        if (aVar == null || !this.f5215e || (e2 = (g2 = aVar.g()).e(i2)) == null) {
            return;
        }
        float d2 = g2.d(e2, i2);
        if (e2.x() && (c = g2.c(i2)) != null && c != e2) {
            c.h(this.f5214d, 0.0f);
        }
        e2.h(this.f5214d, d2);
        this.f5217g = e2;
    }

    public void c(boolean z) {
        this.f5215e = z;
    }

    public com.hw.photomovie.a d() {
        return this.a;
    }

    public abstract void e();

    public void f() {
        com.hw.photomovie.a<T> aVar = this.a;
        if (aVar == null) {
            return;
        }
        e<T> b = aVar.g().b();
        b.q();
        b.s();
    }

    public void g(int i2, int i3, int i4, int i5) {
        com.hw.photomovie.a<T> aVar = this.a;
        if (aVar != null) {
            for (e<T> eVar : aVar.e()) {
                eVar.w(i2, i3, i4, i5);
            }
        }
        this.c.set(i2, i3, i4, i5);
    }

    public void h(a aVar) {
        this.f5216f = aVar;
    }

    public d<T> i(T t) {
        this.f5214d = t;
        return this;
    }

    public void j(com.hw.photomovie.a aVar) {
        this.a = aVar;
        if (this.c.width() <= 0 || this.c.height() <= 0) {
            return;
        }
        Rect rect = this.c;
        g(rect.left, rect.top, rect.right, rect.bottom);
    }
}
