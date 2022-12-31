package com.pinguo.camera360.gallery.ui.b0;

import android.graphics.Rect;
import android.util.SparseArray;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.b0.a;
import com.pinguo.camera360.gallery.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ExpandSlotLayout.java */
/* loaded from: classes3.dex */
public class c extends a {
    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void D() {
        int i2 = this.f6515i;
        int i3 = i2 > this.f6516j ? this.f6514h.f6709d : this.f6514h.f6710e;
        int i4 = this.f6514h.a;
        this.f6513g = i4;
        int max = Math.max(1, (i2 - ((i3 - 1) * i4)) / i3);
        this.f6511e = max;
        if (this.o == null) {
            this.f6512f = this.f6514h.f6711f + max;
        } else {
            this.f6512f = max;
        }
        this.f6517k = i3;
        z.e eVar = this.a;
        if (eVar != null) {
            eVar.j(max, this.f6512f);
        }
        R(this.f6516j, this.f6515i);
        S();
        P();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void F(int i2) {
        if (this.m == i2) {
            return;
        }
        this.m = i2;
        S();
        P();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void O(float f2, float f3) {
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void P() {
        boolean z;
        int i2 = this.m;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (true) {
            z = true;
            if (i3 >= this.p.size()) {
                i3 = 0;
                z = false;
                break;
            }
            a.C0242a c0242a = this.p.get(i3);
            if (!z2 && c0242a.a.bottom >= i2) {
                i4 = i3;
                z2 = true;
            }
            if (z2 && c0242a.a.top >= this.f6516j + i2) {
                break;
            }
            i3++;
        }
        if (!z2) {
            i3 = this.f6510d;
            i4 = i3;
        } else if (!z) {
            i3 = this.f6510d;
        }
        us.pinguo.common.log.a.c("updateVisibleSlotRange:" + i4 + "," + i3, new Object[0]);
        M(i4, i3);
    }

    public void Q() {
        int size = this.o.size();
        y.c cVar = this.o.get(0);
        cVar.f6399k = 0;
        if (size == 1) {
            cVar.f6398j = this.f6510d;
            return;
        }
        for (int i2 = 1; i2 < size; i2++) {
            y.c cVar2 = this.o.get(i2);
            y.c cVar3 = this.o.get(i2 - 1);
            int i3 = cVar2.f6392d;
            int i4 = cVar3.f6399k;
            int i5 = this.f6517k;
            cVar2.f6399k = ((i5 - ((i3 + i4) % i5)) % i5) + i4;
            cVar3.f6398j = i3 - cVar3.f6392d;
            if (i2 == size - 1) {
                cVar2.f6398j = this.f6510d - i3;
            }
        }
    }

    protected void R(int i2, int i3) {
        ArrayList<y.c> arrayList = this.o;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Q();
        us.pinguo.common.log.a.k("-------------compute tags spend time" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        int i4 = this.f6511e;
        int i5 = this.f6513g;
        int i6 = i4 + i5;
        int i7 = this.f6512f + i5;
        int i8 = this.f6514h.f6711f + i5;
        us.pinguo.common.log.a.k("------------1-----------slotCount:" + this.f6510d + " tag size:" + this.o.size(), new Object[0]);
        int i9 = 1;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        while (i10 < this.f6510d) {
            if (this.o.size() != i9) {
                if (i11 < this.o.size()) {
                    y.c cVar = this.o.get(i11);
                    if (i10 < cVar.f6392d) {
                        i12 = this.o.get(i11 - 1).f6399k;
                    } else {
                        int i14 = cVar.f6399k;
                        boolean z = cVar.f6394f;
                        i11 = !z ? i11 + 1 : i11 + 2;
                        if (z) {
                            i13++;
                        }
                        i12 = i14;
                    }
                }
            } else {
                this.o.get(0).f6398j = this.f6510d;
                i12 = 0;
            }
            int i15 = i10 + i12;
            int i16 = this.f6517k;
            int i17 = i15 / i16;
            int i18 = (i15 - (i16 * i17)) * i6;
            int i19 = (i17 * i7) + ((i11 + i13) * i8);
            Rect rect = new Rect();
            rect.set(i18, i19, this.f6511e + i18, this.f6512f + i19);
            this.p.put(i10, new a.C0242a(false, rect));
            i10++;
            i9 = 1;
        }
        int i20 = this.f6515i;
        int i21 = this.f6516j;
        if (i20 <= i21) {
            i20 = this.f6514h.f6716k + i21;
        }
        Iterator<y.c> it = this.o.iterator();
        while (it.hasNext()) {
            y.c next = it.next();
            Rect rect2 = this.p.get(next.f6392d).a;
            if (!next.f6394f) {
                int i22 = rect2.left;
                int i23 = rect2.top;
                next.f6396h = new Rect(i22, i23 - i8, i22 + i20, i23 - this.f6514h.a);
            } else {
                int i24 = rect2.left;
                int i25 = rect2.top;
                next.f6396h = new Rect(i24, i25 - ((i8 * 5) / 2), i24 + i20, i25 - this.f6514h.a);
            }
        }
        if (this.p.size() > 0) {
            SparseArray<a.C0242a> sparseArray = this.p;
            int i26 = sparseArray.get(sparseArray.size() - 1).a.bottom;
            this.f6518l = i26;
            int i27 = this.t;
            if (i27 > 0) {
                this.f6518l = i26 + i27;
            }
        }
        us.pinguo.common.log.a.k("mContentLength 1111 " + this.f6518l, new Object[0]);
        us.pinguo.common.log.a.k("-------------compute all poss spend time" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    protected void S() {
        int[] b = a.b(this.o, this.m, this.f6516j);
        N(b[0], b[1]);
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
        int round = Math.round(f2) + 0;
        int round2 = Math.round(f3) + (this.m - 0);
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            if (this.p.get(i2).a.contains(round, round2)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect q(int i2, Rect rect) {
        if (this.p.size() > 0 && i2 < this.p.size()) {
            return this.p.get(i2).a;
        }
        return new Rect();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public int w(float f2, float f3) {
        if (this.o == null) {
            return -1;
        }
        int round = Math.round(f2) + 0;
        int round2 = Math.round(f3) + (this.m - 0);
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            y.c cVar = this.o.get(i2);
            if (!cVar.f6394f && cVar.f6396h.contains(round - (this.f6515i / 2), round2)) {
                return i2;
            }
        }
        return -1;
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
