package com.pinguo.camera360.gallery.ui.b0;

import android.graphics.Rect;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.b0.a;
import com.pinguo.camera360.gallery.ui.z;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ContractSlotLayout.java */
/* loaded from: classes3.dex */
public class b extends a {
    private List<Integer> v;

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void D() {
        int i2 = this.f6515i;
        int i3 = i2 > this.f6516j ? this.f6514h.f6709d : this.f6514h.f6710e;
        int i4 = this.f6514h.a;
        this.f6513g = i4;
        int max = Math.max(1, (i2 - ((i3 - 1) * i4)) / i3);
        this.f6511e = max;
        this.f6512f = max;
        this.f6517k = i3;
        z.e eVar = this.a;
        if (eVar != null) {
            eVar.j(max, max);
        }
        int i5 = this.f6510d;
        int i6 = this.f6517k;
        int i7 = ((i5 + i6) - 1) / i6;
        int i8 = (this.f6512f * i7) + ((i7 - 1) * this.f6513g);
        this.f6518l = i8;
        int x = i8 + x();
        this.f6518l = x;
        int i9 = this.t;
        if (i9 > 0) {
            this.f6518l = x + i9;
        }
        P();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void K(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3) {
        this.o = arrayList;
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
        int max = Math.max(0, this.f6517k * (i2 / (this.f6512f + this.f6513g)));
        int i3 = i2 + this.f6516j;
        int i4 = this.f6512f;
        int i5 = this.f6513g;
        M(max, Math.min(this.f6510d, this.f6517k * ((((i3 + i4) + i5) - 1) / (i4 + i5))));
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
    public List<Integer> h(float f2, float f3) {
        List<Integer> list = this.v;
        if (list == null) {
            this.v = new ArrayList(3);
        } else {
            list.clear();
        }
        int round = (((Math.round(f3) + this.m) - x()) / (this.f6512f + this.f6513g)) * 3;
        int i2 = round + 2;
        if (round < 0) {
            round = 0;
        }
        int i3 = this.f6510d;
        if (i2 > i3 - 1) {
            i2 = i3 - 1;
        }
        while (round <= i2) {
            this.v.add(Integer.valueOf(round));
            round++;
        }
        return this.v;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect i(int i2, Rect rect) {
        return null;
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
        a.C0242a c0242a = this.p.get(i2);
        if (this.p.size() > 0 && c0242a != null) {
            if (rect == null) {
                return c0242a.a;
            }
            rect.set(c0242a.a);
            return rect;
        }
        Rect rect2 = new Rect();
        int i3 = this.f6517k;
        int i4 = i2 / i3;
        int i5 = this.f6511e;
        int i6 = this.f6513g;
        int i7 = (i2 - (i3 * i4)) * (i5 + i6);
        int x = (i4 * (this.f6512f + i6)) + x();
        rect2.set(i7, x, this.f6511e + i7, this.f6512f + x);
        this.p.put(i2, new a.C0242a(false, rect2));
        return rect;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public float[] y(int i2, float f2, float f3) {
        Rect q = q(i2, new Rect());
        if (q == null) {
            return new float[]{0.0f, 0.0f};
        }
        return new float[]{com.pinguo.album.j.a.d((((Math.round(f2) + 0) - q.left) * 1.0f) / q.width(), 0.0f, 1.0f), com.pinguo.album.j.a.d((((Math.round(f3) + this.m) - q.top) * 1.0f) / q.height(), 0.0f, 1.0f)};
    }
}
