package com.pinguo.album.animations;

import android.graphics.Rect;
import android.view.animation.DecelerateInterpolator;
import com.pinguo.album.opengles.l;
/* compiled from: SlotAnimation.java */
/* loaded from: classes3.dex */
public abstract class h extends b {

    /* renamed from: e  reason: collision with root package name */
    protected float f6003e = 0.0f;

    public h() {
        j(new DecelerateInterpolator(4.0f));
        i(1000);
    }

    @Override // com.pinguo.album.animations.b
    protected void e(float f2) {
        this.f6003e = f2;
    }

    public abstract void m(l lVar, int i2, Rect rect);
}
