package com.pinguo.album.opengles;
/* compiled from: RawTexture.java */
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: k  reason: collision with root package name */
    private final boolean f6088k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6089l;

    public q(int i2, int i3, boolean z) {
        this.f6088k = z;
        r(i2, i3);
    }

    @Override // com.pinguo.album.opengles.u
    public boolean b() {
        return this.f6088k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.opengles.a
    public int f() {
        return 3553;
    }

    @Override // com.pinguo.album.opengles.a
    public boolean l() {
        return this.f6089l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.opengles.a
    public boolean n(l lVar) {
        if (m()) {
            return true;
        }
        us.pinguo.common.log.a.s("lost the content due to context change", new Object[0]);
        return false;
    }

    @Override // com.pinguo.album.opengles.a
    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(l lVar) {
        this.a = lVar.f().b();
        lVar.t(this, 6408, 5121);
        lVar.y(this);
        this.b = 1;
        p(lVar);
    }
}
