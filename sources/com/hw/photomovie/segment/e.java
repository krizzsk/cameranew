package com.hw.photomovie.segment;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: MovieSegment.java */
/* loaded from: classes2.dex */
public abstract class e<T> {
    protected com.hw.photomovie.a b;

    /* renamed from: e  reason: collision with root package name */
    protected int f5220e;

    /* renamed from: g  reason: collision with root package name */
    protected a f5222g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f5223h;
    protected boolean a = false;
    private List<com.hw.photomovie.b.b> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    protected List<com.hw.photomovie.b.b> f5219d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    protected RectF f5221f = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private boolean f5224i = true;

    /* renamed from: j  reason: collision with root package name */
    protected com.hw.photomovie.segment.h.b f5225j = new com.hw.photomovie.segment.h.a();

    /* compiled from: MovieSegment.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z);
    }

    public void e(List<com.hw.photomovie.b.b> list) {
        this.c.clear();
        this.c.addAll(list);
    }

    protected void f() {
        List<com.hw.photomovie.b.b> list = this.c;
        if (list == null || list.size() == 0) {
            return;
        }
        boolean z = true;
        Iterator<com.hw.photomovie.b.b> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getState() < 2) {
                z = false;
                break;
            }
        }
        this.f5219d.clear();
        if (z) {
            this.f5219d.addAll(this.c);
        } else {
            this.f5219d.addAll(this.f5225j.a(this.b, this));
        }
    }

    protected abstract boolean g();

    public abstract void h(T t, float f2);

    public final void i(boolean z) {
        this.f5224i = z;
    }

    public List<com.hw.photomovie.b.b> j() {
        return this.c;
    }

    public int k() {
        return this.f5220e;
    }

    public com.hw.photomovie.b.b l(int i2) {
        if (i2 < 0 || i2 >= this.f5219d.size()) {
            return null;
        }
        return this.f5219d.get(i2);
    }

    public abstract int m();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void n();

    protected abstract void o();

    protected abstract void p();

    public void q() {
    }

    public final void r() {
        if (g()) {
            a aVar = this.f5222g;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
            return;
        }
        f();
        o();
        if (this.a) {
            this.b.c();
        }
    }

    public final void s() {
        if (this.f5224i) {
            p();
        }
    }

    public e t(int i2) {
        this.f5220e = i2;
        return this;
    }

    public void u(a aVar) {
        this.f5222g = aVar;
    }

    public void v(com.hw.photomovie.a aVar) {
        this.b = aVar;
    }

    public void w(int i2, int i3, int i4, int i5) {
        this.f5221f.set(i2, i3, i4, i5);
    }

    public boolean x() {
        return false;
    }
}
