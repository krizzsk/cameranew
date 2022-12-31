package com.pinguo.album.animations;

import android.graphics.Rect;
import com.pinguo.album.opengles.l;
import us.pinguo.foundation.utils.n0;
/* compiled from: SlotTransAnimation.java */
/* loaded from: classes3.dex */
public class i extends h {

    /* renamed from: f  reason: collision with root package name */
    private int f6004f;

    /* renamed from: g  reason: collision with root package name */
    private int f6005g;

    public i() {
        this.f6004f = n0.i();
        this.f6005g = 2;
    }

    @Override // com.pinguo.album.animations.h
    public void m(l lVar, int i2, Rect rect) {
        int i3 = this.f6005g;
        if (i3 == 2) {
            lVar.p(this.f6004f * (1.0f - this.f6003e), 0.0f, 0.0f);
        } else if (i3 == 1) {
            lVar.p(this.f6004f * this.f6003e, 0.0f, 0.0f);
        } else if (i3 == 3) {
            lVar.p(0.0f, this.f6004f * (1.0f - this.f6003e), 0.0f);
        } else if (i3 == 4) {
            lVar.p(0.0f, (-this.f6004f) * (1.0f - this.f6003e), 0.0f);
        }
    }

    public void n(int i2) {
        this.f6005g = i2;
    }

    public void o(int i2) {
        this.f6004f = i2;
    }

    public i(int i2) {
        this.f6004f = n0.i();
        this.f6005g = 2;
        this.f6004f = i2;
    }

    public i(int i2, int i3) {
        this(i2);
        this.f6005g = i3;
    }
}
