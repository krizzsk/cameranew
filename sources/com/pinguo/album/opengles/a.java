package com.pinguo.album.opengles;

import java.util.WeakHashMap;
/* compiled from: BasicTexture.java */
/* loaded from: classes3.dex */
public abstract class a implements u {

    /* renamed from: i  reason: collision with root package name */
    private static WeakHashMap<a, Object> f6049i = new WeakHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static ThreadLocal f6050j = new ThreadLocal();
    protected int a;
    protected int b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected int f6051d;

    /* renamed from: e  reason: collision with root package name */
    protected int f6052e;

    /* renamed from: f  reason: collision with root package name */
    protected int f6053f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6054g;

    /* renamed from: h  reason: collision with root package name */
    protected l f6055h;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(l lVar, int i2, int i3) {
        this.a = -1;
        this.c = -1;
        this.f6051d = -1;
        this.f6055h = null;
        p(lVar);
        this.a = i2;
        this.b = i3;
        synchronized (f6049i) {
            f6049i.put(this, null);
        }
    }

    private void d() {
        l lVar = this.f6055h;
        if (lVar != null && this.a != -1) {
            lVar.o(this);
            this.a = -1;
        }
        this.b = 0;
        p(null);
    }

    public static boolean j() {
        return f6050j.get() != null;
    }

    public static void k() {
        synchronized (f6049i) {
            for (a aVar : f6049i.keySet()) {
                aVar.b = 0;
                aVar.p(null);
            }
        }
    }

    public static void t() {
        synchronized (f6049i) {
            for (a aVar : f6049i.keySet()) {
                aVar.s();
            }
        }
    }

    @Override // com.pinguo.album.opengles.u
    public void a(l lVar, int i2, int i3, int i4, int i5) {
        if (lVar == null) {
            return;
        }
        lVar.l(this, i2, i3, i4, i5);
    }

    @Override // com.pinguo.album.opengles.u
    public void c(l lVar, int i2, int i3) {
        if (lVar == null) {
            return;
        }
        lVar.l(this, i2, i3, getWidth(), getHeight());
    }

    public int e() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int f();

    protected void finalize() {
        f6050j.set(a.class);
        o();
        f6050j.set(null);
    }

    public int g() {
        return this.f6053f;
    }

    @Override // com.pinguo.album.opengles.u
    public int getHeight() {
        return this.f6051d;
    }

    @Override // com.pinguo.album.opengles.u
    public int getWidth() {
        return this.c;
    }

    public int h() {
        return this.f6052e;
    }

    public boolean i() {
        return this.f6054g;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return this.b == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean n(l lVar);

    public void o() {
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(l lVar) {
        this.f6055h = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        this.f6054g = z;
    }

    public void r(int i2, int i3) {
        this.c = i2;
        this.f6051d = i3;
        this.f6052e = i2 > 0 ? com.pinguo.album.j.a.p(i2) : 0;
        int p = i3 > 0 ? com.pinguo.album.j.a.p(i3) : 0;
        this.f6053f = p;
        int i4 = this.f6052e;
        if (i4 > 4096 || p > 4096) {
            us.pinguo.common.log.a.s(String.format("texture is too large: %d x %d", Integer.valueOf(i4), Integer.valueOf(this.f6053f)), new Exception());
        }
    }

    public void s() {
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this(null, 0, 0);
    }
}
