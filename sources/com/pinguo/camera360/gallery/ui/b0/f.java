package com.pinguo.camera360.gallery.ui.b0;

import android.graphics.Rect;
import com.pinguo.camera360.gallery.data.w;
import com.pinguo.camera360.gallery.ui.z;
/* compiled from: MatchWidthListSlotLayout.java */
/* loaded from: classes3.dex */
public class f extends a {
    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void D() {
        int i2 = this.f6514h.a;
        this.f6513g = i2;
        this.f6511e = Math.max(1, (this.f6515i - (i2 * 0)) / 1);
        this.f6512f = w.f6388g;
        d.f.a.b.d.d("initLayoutParameters mSlotWidth = " + this.f6511e, new Object[0]);
        this.f6517k = 1;
        z.e eVar = this.a;
        if (eVar != null) {
            eVar.j(this.f6511e, this.f6512f);
        }
        int i3 = this.f6510d;
        int i4 = this.f6517k;
        int i5 = ((i3 + i4) - 1) / i4;
        int i6 = (this.f6512f * i5) + ((i5 - 1) * this.f6513g);
        this.f6518l = i6;
        int x = i6 + x();
        this.f6518l = x;
        int i7 = this.t;
        if (i7 > 0) {
            this.f6518l = x + i7;
        }
        P();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void O(float f2, float f3) {
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void P() {
        int i2 = this.m;
        if (i2 > x()) {
            i2 -= x();
        }
        int i3 = this.f6512f + this.f6513g;
        M(Math.max(0, this.f6517k * (i2 / i3)), Math.min(this.f6510d, this.f6517k * ((((i2 + this.f6516j) + i3) - 1) / i3)));
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect f(int i2, Rect rect) {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect g(int i2, Rect rect) {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect i(int i2, Rect rect) {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public int l() {
        return 20;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public int o(float f2, float f3) {
        int i2;
        int round = Math.round(f2) + 0;
        int round2 = (Math.round(f3) + this.m) - x();
        if (round < 0 || round2 < 0) {
            return -1;
        }
        int i3 = this.f6511e;
        int i4 = this.f6513g;
        int i5 = round / (i3 + i4);
        int i6 = this.f6512f;
        int i7 = round2 / (i6 + i4);
        int i8 = this.f6517k;
        if (i5 < i8 && round % (i3 + i4) < i3 && round2 % (i4 + i6) < i6 && (i2 = (i7 * i8) + i5) < this.f6510d) {
            return i2;
        }
        return -1;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect q(int i2, Rect rect) {
        int i3 = this.f6517k;
        int i4 = i2 / i3;
        int i5 = i2 - (i3 * i4);
        int i6 = this.f6511e;
        int i7 = this.f6513g;
        int i8 = i5 * (i6 + i7);
        int x = (i4 * (this.f6512f + i7)) + x();
        rect.set(i8, x, this.f6511e + i8, this.f6512f + x);
        return rect;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public float[] y(int i2, float f2, float f3) {
        Rect rect = new Rect();
        q(i2, rect);
        return new float[]{com.pinguo.album.j.a.d((((Math.round(f2) + 0) - rect.left) * 1.0f) / rect.width(), 0.0f, 1.0f), com.pinguo.album.j.a.d((((Math.round(f3) + this.m) - rect.top) * 1.0f) / rect.height(), 0.0f, 1.0f)};
    }
}
