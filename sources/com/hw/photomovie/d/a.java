package com.hw.photomovie.d;

import android.opengl.GLES20;
import java.util.WeakHashMap;
/* compiled from: BasicTexture.java */
/* loaded from: classes2.dex */
public abstract class a implements i {

    /* renamed from: i  reason: collision with root package name */
    private static WeakHashMap<a, Object> f5155i = new WeakHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static ThreadLocal f5156j = new ThreadLocal();
    protected int a;
    protected int b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected int f5157d;

    /* renamed from: e  reason: collision with root package name */
    protected int f5158e;

    /* renamed from: f  reason: collision with root package name */
    protected int f5159f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5160g;

    /* renamed from: h  reason: collision with root package name */
    protected f f5161h;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(f fVar, int i2, int i3) {
        this.a = -1;
        this.c = -1;
        this.f5157d = -1;
        this.f5161h = null;
        n(fVar);
        this.a = i2;
        this.b = i3;
        synchronized (f5155i) {
            f5155i.put(this, null);
        }
    }

    private void a() {
        f fVar = this.f5161h;
        if (fVar != null && this.a != -1) {
            fVar.p(this);
            this.a = -1;
        }
        this.b = 0;
        n(null);
    }

    public int c() {
        return this.f5157d;
    }

    public int d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int e();

    public int f() {
        return this.f5159f;
    }

    protected void finalize() {
        f5156j.set(a.class);
        m();
        f5156j.set(null);
    }

    public int g() {
        return this.f5158e;
    }

    public int h() {
        return this.c;
    }

    public boolean i() {
        return this.f5160g;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this.b == 1 && GLES20.glIsTexture(this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean l(f fVar);

    public void m() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(f fVar) {
        this.f5161h = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(boolean z) {
        this.f5160g = z;
    }

    public void p(int i2, int i3) {
        this.c = i2;
        this.f5157d = i3;
        this.f5158e = i2;
        this.f5159f = i3;
        if (i2 > 4096 || i3 > 4096) {
            com.hw.photomovie.util.b.e("BasicTexture", String.format("texture is too large: %d x %d", Integer.valueOf(i2), Integer.valueOf(this.f5159f)), new Exception());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this(null, 0, 0);
    }
}
