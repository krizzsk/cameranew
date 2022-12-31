package com.pinguo.album.opengles;
/* compiled from: FadeOutTexture.java */
/* loaded from: classes3.dex */
public class f extends g {
    public f(a aVar) {
        super(aVar);
    }

    @Override // com.pinguo.album.opengles.u
    public void a(l lVar, int i2, int i3, int i4, int i5) {
        if (e()) {
            lVar.s(1);
            lVar.setAlpha(d());
            this.a.a(lVar, i2, i3, i4, i5);
            lVar.b();
        }
    }
}
