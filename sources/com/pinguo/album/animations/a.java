package com.pinguo.album.animations;

import android.graphics.Rect;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.pinguo.album.opengles.l;
/* compiled from: AlphaAnimation.java */
/* loaded from: classes3.dex */
public class a extends h {
    public a() {
        j(new AccelerateDecelerateInterpolator());
    }

    @Override // com.pinguo.album.animations.h
    public void m(l lVar, int i2, Rect rect) {
        lVar.setAlpha(1.0f - this.f6003e);
    }

    public float n() {
        return this.f6003e;
    }
}
