package com.pinguo.camera360.gallery.ui.b0;

import android.graphics.Rect;
import com.pinguo.camera360.gallery.ui.z;
import us.pinguo.foundation.utils.n0;
/* compiled from: ListSlotLayout.java */
/* loaded from: classes3.dex */
public class e extends a {
    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void D() {
        if (this.f6515i > this.f6516j) {
            int i2 = this.f6514h.f6709d;
        } else {
            int i3 = this.f6514h.f6710e;
        }
        this.f6513g = this.f6514h.b;
        int c = n0.c(90);
        this.f6511e = c;
        this.f6512f = c;
        z.e eVar = this.a;
        if (eVar != null) {
            eVar.j(c, c);
        }
        int i4 = (this.f6510d * (this.f6512f + (this.f6513g * 2))) + this.f6514h.c;
        this.f6518l = i4;
        int x = i4 + x();
        this.f6518l = x;
        int i5 = this.t;
        if (i5 > 0) {
            this.f6518l = x + i5;
        }
        P();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void G(int i2, int i3) {
        this.f6515i = i2;
        this.f6516j = i3;
        D();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void O(float f2, float f3) {
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void P() {
        int i2 = this.m;
        if (i2 > x()) {
            i2 -= x();
        }
        int i3 = this.f6512f + (this.f6513g << 1);
        int i4 = this.f6514h.c;
        if (i2 > i3 + i4) {
            i2 -= i4;
        }
        M(Math.max(0, i2 / i3), Math.min(this.f6510d, (((i2 + this.f6516j) + i3) - 1) / i3));
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
    public int o(float f2, float f3) {
        int round = Math.round(f2);
        int round2 = (Math.round(f3) + this.m) - x();
        int i2 = this.f6512f + (this.f6513g << 1);
        if (round < 0 || round2 < 0) {
            return -1;
        }
        if (round2 <= i2 || round2 >= this.f6514h.c + i2) {
            int i3 = this.f6514h.c;
            if (round2 > i2 + i3) {
                round2 -= i3;
            }
            int i4 = round2 / i2;
            if (i4 >= this.f6510d) {
                return -1;
            }
            return i4;
        }
        return -1;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect q(int i2, Rect rect) {
        int i3 = this.f6513g;
        int x = ((this.f6512f + (i3 * 2)) * i2) + x() + this.f6513g;
        if (i2 != 0) {
            x += this.f6514h.c;
        }
        int i4 = this.f6512f;
        rect.set(i3, x, i3 + i4, i4 + x);
        return rect;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public float[] y(int i2, float f2, float f3) {
        Rect rect = new Rect();
        q(i2, rect);
        return new float[]{com.pinguo.album.j.a.d(((Math.round(f2) - rect.left) * 1.0f) / rect.width(), 0.0f, 1.0f), com.pinguo.album.j.a.d((((Math.round(f3) + this.m) - rect.top) * 1.0f) / rect.height(), 0.0f, 1.0f)};
    }
}
