package com.pinguo.album.opengles;
/* compiled from: FadeTexture.java */
/* loaded from: classes3.dex */
public abstract class g implements u {
    protected final a a;
    private final long b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6061d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6062e;

    public g(a aVar) {
        this.a = aVar;
        this.c = aVar.getWidth();
        this.f6061d = aVar.getHeight();
        aVar.b();
        this.b = f();
        this.f6062e = true;
    }

    private long f() {
        return com.pinguo.album.animations.c.a();
    }

    @Override // com.pinguo.album.opengles.u
    public void c(l lVar, int i2, int i3) {
        a(lVar, i2, i3, this.c, this.f6061d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        return com.pinguo.album.j.a.d(1.0f - (((float) (f() - this.b)) / 180.0f), 0.0f, 1.0f);
    }

    public boolean e() {
        if (this.f6062e && f() - this.b >= 180) {
            this.f6062e = false;
        }
        return this.f6062e;
    }

    @Override // com.pinguo.album.opengles.u
    public int getHeight() {
        return this.f6061d;
    }

    @Override // com.pinguo.album.opengles.u
    public int getWidth() {
        return this.c;
    }
}
