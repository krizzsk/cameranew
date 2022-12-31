package com.pinguo.album.animations;

import android.graphics.Rect;
import com.pinguo.album.opengles.l;
/* compiled from: ScatteringAnimation.java */
/* loaded from: classes3.dex */
public class g extends h {

    /* renamed from: f  reason: collision with root package name */
    private int f6001f = 1000;

    /* renamed from: g  reason: collision with root package name */
    private com.pinguo.album.j.i f6002g;

    public g(com.pinguo.album.j.i iVar) {
        this.f6002g = iVar;
    }

    @Override // com.pinguo.album.animations.h
    public void m(l lVar, int i2, Rect rect) {
        float a = (this.f6002g.a() - rect.centerX()) * (1.0f - this.f6003e);
        float b = this.f6002g.b() - rect.centerY();
        float f2 = this.f6003e;
        lVar.p(a, b * (1.0f - f2), i2 * this.f6001f * (1.0f - f2));
        lVar.setAlpha(this.f6003e);
    }
}
