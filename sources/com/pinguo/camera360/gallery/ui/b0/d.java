package com.pinguo.camera360.gallery.ui.b0;

import android.graphics.Rect;
import android.util.SparseArray;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.b0.a;
import com.pinguo.camera360.gallery.ui.z;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FlowSlotLayout.java */
/* loaded from: classes3.dex */
public class d extends a {
    private ArrayList<y.b> v;
    private List<Integer> w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        us.pinguo.common.log.a.k("FlowSlotLayout", new Object[0]);
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void D() {
        SparseArray<a.C0242a> sparseArray;
        int i2 = 0;
        us.pinguo.common.log.a.k("initLayoutParameters", new Object[0]);
        SparseArray<a.C0242a> sparseArray2 = this.p;
        if (sparseArray2 != null) {
            sparseArray2.clear();
        }
        ArrayList<y.c> arrayList = this.o;
        if (arrayList != null && arrayList.size() != 0) {
            z.f fVar = this.f6514h;
            int i3 = fVar.a;
            this.f6513g = i3;
            int i4 = fVar.f6711f + i3;
            int x = x();
            int i5 = this.f6515i - this.f6513g;
            int i6 = 0;
            while (i6 < this.o.size()) {
                y.c cVar = this.o.get(i6);
                int i7 = x + i4;
                cVar.f6396h = new Rect(i2, x, this.f6515i, i7);
                int i8 = cVar.f6392d;
                int i9 = cVar.f6393e + i8;
                while (i8 < i9) {
                    y.b bVar = this.v.get(i8);
                    int i10 = i8 + 1;
                    if (i10 < i9) {
                        y.b bVar2 = this.v.get(i10);
                        float f2 = i5;
                        int i11 = bVar.c;
                        float f3 = (i11 * 1.0f) / bVar2.a;
                        int i12 = bVar.b;
                        float f4 = f2 / (f3 + i12);
                        float f5 = (bVar2.c * 1.0f) / bVar.a;
                        int i13 = bVar2.b;
                        int i14 = (int) (i11 * f4);
                        int i15 = (int) (i12 * f4);
                        int i16 = i7 + i14;
                        Rect rect = new Rect(0, i7, i15, i16);
                        int i17 = this.f6513g;
                        Rect rect2 = new Rect(i15 + i17, i7, i15 + i17 + ((int) (i13 * (f2 / (f5 + i13)))), i16);
                        this.p.put(i8, new a.C0242a(false, rect));
                        this.p.put(i10, new a.C0242a(false, rect2));
                        i8 += 2;
                        i7 += i14 + this.f6513g;
                    } else {
                        int i18 = (int) (((this.f6515i * 1.0f) / bVar.b) * bVar.c);
                        this.p.put(i8, new a.C0242a(false, new Rect(0, i7, this.f6515i, i7 + i18)));
                        i7 += i18 + this.f6513g;
                        i8 = i10;
                    }
                }
                i6++;
                x = i7;
                i2 = 0;
            }
            if (this.p.size() > 0) {
                int i19 = this.p.get(sparseArray.size() - 1).a.bottom;
                this.f6518l = i19;
                int i20 = this.t;
                if (i20 > 0) {
                    this.f6518l = i19 + i20;
                }
            }
            Q();
            P();
            return;
        }
        N(0, 0);
        M(0, 0);
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void F(int i2) {
        if (this.m == i2) {
            return;
        }
        this.m = i2;
        Q();
        P();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void K(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3) {
        this.o = arrayList;
        this.v = arrayList3;
        us.pinguo.common.log.a.k("setSortTags:" + this.o + "," + this.v, new Object[0]);
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

    protected void Q() {
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
    public List<Integer> h(float f2, float f3) {
        int i2;
        List<Integer> list = this.w;
        if (list == null) {
            this.w = new ArrayList(3);
        } else {
            list.clear();
        }
        int round = (Math.round(f3) + this.m) - x();
        int i3 = 0;
        int size = this.p.size() - 1;
        while (true) {
            if (i3 > size) {
                i2 = -1;
                break;
            }
            i2 = (i3 + size) >>> 1;
            Rect rect = this.p.get(i2).a;
            int i4 = rect.top;
            int i5 = rect.bottom;
            if (i5 >= round) {
                if (i5 > round && i4 < round) {
                    this.w.add(Integer.valueOf(i2));
                    break;
                }
                size = i2 - 1;
            } else {
                i3 = i2 + 1;
            }
        }
        if (i2 != -1) {
            Rect rect2 = this.p.get(i2).a;
            int i6 = i2 - 1;
            int i7 = i2 + 1;
            if (i6 >= 0 && this.p.get(i6).a.top == rect2.top) {
                this.w.add(Integer.valueOf(i6));
            }
            if (i7 < this.p.size() && this.p.get(i7).a.top == rect2.top) {
                this.w.add(Integer.valueOf(i7));
            }
        }
        return this.w;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect i(int i2, Rect rect) {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public int l() {
        return 15;
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
    public SparseArray<a.C0242a> p() {
        return this.p;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect q(int i2, Rect rect) {
        if (this.p.size() <= 0 || i2 >= this.p.size()) {
            return rect;
        }
        if (this.p.get(i2) == null) {
            return new Rect();
        }
        if (rect == null) {
            return this.p.get(i2).a;
        }
        rect.set(this.p.get(i2).a);
        return rect;
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
