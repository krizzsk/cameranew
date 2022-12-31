package com.pinguo.camera360.gallery.ui.b0;

import android.graphics.Rect;
import android.util.SparseArray;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.b0.a;
import com.pinguo.camera360.gallery.ui.l;
import com.pinguo.camera360.gallery.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vStudio.Android.Camera360.R;
/* compiled from: ScaleSlotLayout.java */
/* loaded from: classes3.dex */
public class g extends com.pinguo.camera360.gallery.ui.b0.a {
    protected int A;
    protected int B;
    private c C;
    private c D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    protected ArrayList<y.c> v;
    protected int y;
    protected int z;
    protected SparseArray<a.C0242a> w = new SparseArray<>();
    protected ArrayList<y.c> x = new ArrayList<>();
    public int J = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScaleSlotLayout.java */
    /* loaded from: classes3.dex */
    public static class b {
        public int a;
        public Rect b;
        public int c;

        public b(int i2, Rect rect) {
            this.a = i2;
            this.b = rect;
        }

        public void a(int i2) {
            this.c = i2;
        }

        public void b(boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScaleSlotLayout.java */
    /* loaded from: classes3.dex */
    public static class c {
        private ArrayList<b> a;
        private ArrayList<b> b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f6519d;

        /* renamed from: e  reason: collision with root package name */
        public SparseArray<a.C0242a> f6520e;

        /* renamed from: f  reason: collision with root package name */
        public SparseArray<a.C0242a> f6521f;

        private c() {
            this.a = new ArrayList<>();
            this.b = new ArrayList<>();
            this.f6520e = new SparseArray<>();
            this.f6521f = new SparseArray<>();
        }

        public ArrayList<b> a() {
            return this.a;
        }

        public ArrayList<b> b() {
            return this.b;
        }
    }

    private Rect Q(int i2, ArrayList<y.c> arrayList, int i3, int i4, int i5, int i6, int i7) {
        y.c cVar;
        if (arrayList == null || arrayList.size() == 0) {
            cVar = null;
        } else {
            arrayList.size();
            cVar = a0(arrayList, i2);
            if (cVar == null) {
                cVar = arrayList.get(arrayList.size() - 1);
            }
        }
        if (cVar != null) {
            int i8 = i5 + i4;
            int i9 = i2 - cVar.f6392d;
            int i10 = i9 / i3;
            int i11 = i9 - (i3 * i10);
            us.pinguo.common.log.a.k("getSlotRect col = " + i11 + " row = " + i10 + " index = " + i2 + " currentIndexTag.index = " + cVar.f6392d, new Object[0]);
            int i12 = i11 * i8;
            int i13 = (i10 * i8) + cVar.f6396h.bottom;
            us.pinguo.common.log.a.k("getSlotRect offsetHeight =  x = " + i12 + " y = " + i13 + " slotWidth = " + i4, new Object[0]);
            Rect rect = new Rect();
            rect.set(i12, i13, i12 + i4, i4 + i13);
            return rect;
        }
        return null;
    }

    private List<Integer> X(ArrayList<y.c> arrayList, int i2, int i3, int i4, float f2) {
        y.c cVar;
        int i5;
        int i6;
        ArrayList arrayList2 = new ArrayList(i3);
        int round = Math.round(f2) + i4;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i8 >= arrayList.size()) {
                cVar = null;
                i5 = 0;
                break;
            } else if (arrayList.get(i8).f6396h.top > round) {
                int i9 = i8 - 1;
                if (i9 < 0) {
                    i9 = 0;
                }
                cVar = arrayList.get(i9);
                i5 = cVar.f6395g;
            } else {
                i8++;
            }
        }
        us.pinguo.common.log.a.k("getSlotIndexByPosition curTagRows - " + i5, new Object[0]);
        if (cVar == null) {
            cVar = arrayList.get(arrayList.size() - 1);
            i5 = cVar.f6395g;
        }
        int i10 = round - cVar.f6396h.bottom;
        if (i10 < 0) {
            return null;
        }
        if (i10 % i2 == 0) {
            i6 = i10 / i2;
        } else {
            i6 = (i10 / i2) + 1;
        }
        if (i6 <= i5) {
            i5 = i6;
        }
        int i11 = i5 - 1;
        if (i11 < 0) {
            i11 = 0;
        }
        int i12 = cVar.f6392d;
        int i13 = (i11 * i3) + i12;
        int e2 = com.pinguo.album.j.a.e(i3 + i13, 0, i12 + cVar.f6393e) - i13;
        while (i7 < e2) {
            arrayList2.add(Integer.valueOf(i13));
            i7++;
            i13++;
        }
        return arrayList2;
    }

    private int Y(ArrayList<y.c> arrayList, int i2, int i3, int i4, int i5, float f2, float f3) {
        int i6;
        int i7;
        int i8;
        int i9;
        int round = Math.round(f2) + 0;
        int round2 = Math.round(f3) + (i4 - 0);
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        y.c cVar = null;
        int i10 = 0;
        while (true) {
            if (i10 >= arrayList.size()) {
                i6 = 0;
                break;
            } else if (arrayList.get(i10).f6396h.top > round2) {
                int i11 = i10 - 1;
                if (i11 < 0) {
                    i11 = 0;
                }
                cVar = arrayList.get(i11);
                i6 = cVar.f6395g;
            } else {
                i10++;
            }
        }
        us.pinguo.common.log.a.k("getSlotIndexByPosition curTagRows - " + i6, new Object[0]);
        if (cVar == null) {
            cVar = arrayList.get(arrayList.size() - 1);
            i6 = cVar.f6395g;
        }
        if (round2 <= i5 && (i7 = round2 - cVar.f6396h.bottom) >= 0) {
            if (i7 % i2 == 0) {
                i8 = i7 / i2;
            } else {
                i8 = (i7 / i2) + 1;
            }
            if (i8 <= i6) {
                i6 = i8;
            }
            if (round % i2 == 0) {
                i9 = round / i2;
            } else {
                i9 = (round / i2) + 1;
            }
            int i12 = cVar.f6392d;
            int i13 = ((((i6 - 1) * i3) + i12) + i9) - 1;
            if (i13 < i12 + cVar.f6393e && i13 >= -1) {
                return i13;
            }
            return -1;
        }
        return -1;
    }

    private int Z(float f2, float f3, ArrayList<y.c> arrayList, int i2) {
        if (arrayList == null) {
            return -1;
        }
        int round = Math.round(f2) + 0;
        int round2 = Math.round(f3) + (i2 - 0);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            y.c cVar = arrayList.get(i3);
            if (!cVar.f6394f && cVar.f6396h.contains(round - (this.f6515i / 2), round2)) {
                return i3;
            }
        }
        return -1;
    }

    private y.c a0(ArrayList<y.c> arrayList, int i2) {
        y.c cVar;
        int size = arrayList.size();
        us.pinguo.common.log.a.k("\n===============================二分法start===============================\ngetTagIndex tagStartIndex = 0 tagEndIndex = " + size + " slotIndex = " + i2, new Object[0]);
        int i3 = 0;
        while (true) {
            if (i3 > size) {
                cVar = null;
                break;
            }
            int i4 = (i3 + size) / 2;
            cVar = arrayList.get(i4);
            us.pinguo.common.log.a.k("getTagIndex tagStartIndex = " + i3 + " tagEndIndex = " + size + " slotIndex = " + i2 + " tag.index  = " + cVar.f6392d + " tag.slotCount = " + cVar.f6393e, new Object[0]);
            int i5 = cVar.f6392d;
            if (i5 > i2) {
                us.pinguo.common.log.a.k("getTagIndex tagStartIndex = " + i4 + " haLF = " + i4, new Object[0]);
                size = i4;
            } else if (i5 + cVar.f6393e > i2 || i3 == i4) {
                break;
            } else {
                i3 = i4;
            }
        }
        us.pinguo.common.log.a.k("\ngetTagIndex tagStartIndex = " + i3 + " tagEndIndex = " + size + " slotIndex = " + i2 + "currentIndexTag" + cVar + "\n===============================二分法end===============================\n", new Object[0]);
        return cVar;
    }

    private void b0() {
        this.G = 0;
        this.H = 0;
        int i2 = this.f6514h.f6709d;
        int i3 = (int) ((this.f6513g * 0.5f) + 0.5f);
        this.I = i3;
        int max = (int) Math.max(1.0f, ((this.f6515i - ((i2 - 1) * i3)) / i2) + 0.5f);
        this.y = max;
        if (this.x == null) {
            this.z = max + this.f6514h.f6711f;
        } else {
            this.z = max;
        }
        this.B = i2;
        c0(this.f6516j, this.f6515i);
        n0();
        int[] p0 = p0(this.x, this.B, false);
        f0(p0[0], p0[1]);
    }

    private void c0(int i2, int i3) {
        SparseArray<a.C0242a> sparseArray = this.w;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        int size = this.x.size();
        ArrayList<y.c> arrayList = this.x;
        if (arrayList == null || size == 0) {
            return;
        }
        int i4 = this.z;
        int i5 = this.I;
        int i6 = i4 + i5;
        e0(arrayList, i6, i5);
        y.c cVar = this.x.get(size - 1);
        this.A = cVar.f6396h.bottom + (cVar.f6395g * i6) + x();
        us.pinguo.common.log.a.k("mContentLength 222 " + this.A, new Object[0]);
    }

    private void e0(ArrayList<y.c> arrayList, int i2, int i3) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int i4 = this.f6514h.f6711f + i3;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            y.c cVar = arrayList.get(i5);
            int i6 = i5 - 1;
            y.c cVar2 = i6 < 0 ? null : arrayList.get(i6);
            int i7 = cVar2 != null ? (cVar2.f6395g * i2) + cVar2.f6396h.bottom : 0;
            if (i5 == 0) {
                cVar.f6396h = new Rect(0, x(), this.f6515i, x() + i4);
            } else {
                cVar.f6396h = new Rect(0, i7, this.f6515i + 0, i7 + i4);
            }
        }
    }

    private void f0(int i2, int i3) {
        us.pinguo.common.log.a.c("setFinalVisibleRange:" + i2 + "," + i3, new Object[0]);
        if (i2 == this.G && i3 == this.H) {
            return;
        }
        if (i2 < i3) {
            if (i3 - i2 > l()) {
                i3 = l() + i2;
                if (us.pinguo.common.log.a.l()) {
                    throw new NullPointerException("pls report this bug to developer asap");
                }
            }
            this.G = i2;
            this.H = i3;
        } else {
            this.H = 0;
            this.G = 0;
        }
        while (i2 < i3) {
            if (this.w.get(i2) == null) {
                this.w.put(i2, new a.C0242a(false, Q(i2, this.x, this.B, this.y, this.I, this.E, this.F)));
            }
            i2++;
        }
    }

    private void g0(int i2, int i3) {
        if (i2 == this.E && i3 == this.F) {
            return;
        }
        if (i2 < i3) {
            this.E = i2;
            this.F = i3;
        } else {
            this.F = 0;
            this.E = 0;
        }
        z.e eVar = this.a;
        if (eVar != null) {
            eVar.i(this.E, this.F, l.p);
        }
    }

    private void h0() {
        if (this.a != null) {
            int i2 = this.G;
            int i3 = this.b;
            if (i2 > i3) {
                i2 = i3;
            }
            int i4 = this.H;
            int i5 = this.c;
            if (i4 <= i5) {
                i4 = i5;
            }
            us.pinguo.common.log.a.k("slotRangeChanged mVisibleSlotStart  = " + this.b + "/" + this.c, new Object[0]);
            us.pinguo.common.log.a.k("slotRangeChanged mScaleDesVisibleSlotStart  = " + this.G + "/" + this.H, new Object[0]);
            if (i4 - i2 > l()) {
                i4 = l() + i2;
            }
            this.a.d(i2, i4);
        }
    }

    private void i0() {
        int i2;
        int i3 = this.n;
        int i4 = this.f6516j + i3;
        int i5 = this.G;
        us.pinguo.common.log.a.k("updateCurPageFinalInfo mScaleDesVisibleSlotStart = " + this.G + " mScaleDesVisibleSlotEnd = " + this.H, new Object[0]);
        int i6 = this.G;
        a.C0242a c0242a = null;
        while (true) {
            i2 = this.H;
            if (i6 >= i2) {
                break;
            }
            a.C0242a c0242a2 = this.w.get(i6);
            if (c0242a2 == null) {
                g(i6, null);
                c0242a2 = this.w.get(i6);
            }
            if (c0242a != null) {
                int i7 = c0242a2.a.bottom;
                Rect rect = c0242a.a;
                if (i7 != rect.bottom) {
                    int i8 = i6 - i5;
                    b bVar = new b(i6 - i8, rect);
                    bVar.a(i8);
                    this.D.a().add(bVar);
                    i5 = i6;
                }
            }
            i6++;
            c0242a = c0242a2;
        }
        c cVar = this.D;
        cVar.c = this.G;
        cVar.f6519d = i2 - 1;
        b bVar2 = new b(i5, this.w.get(i5).a);
        bVar2.a(this.H - i5);
        this.D.a().add(bVar2);
        c cVar2 = this.D;
        int i9 = this.H;
        cVar2.f6519d = i9 - 1;
        int i10 = i9 - 1;
        cVar2.f6519d = i10;
        for (int i11 = this.E; i11 < this.F; i11++) {
            y.c cVar3 = this.x.get(i11);
            us.pinguo.common.log.a.k("updateCurPageSlotAndTagInfo cur tag curTag.pos.bottom= " + cVar3.f6396h.bottom, new Object[0]);
            Rect rect2 = cVar3.f6396h;
            if (rect2.top < i3 || rect2.bottom > i4) {
                break;
            }
            us.pinguo.common.log.a.k("updateCurPageSlotAndTagInfo cur tag rect 111= " + cVar3.f6396h.bottom + " mScaleDesVisibleTagStart = " + this.E + " mScaleDesVisibleTagEnd = " + this.F, new Object[0]);
            this.D.b().add(new b(i11, cVar3.f6396h));
        }
        us.pinguo.common.log.a.k("updateCurPageSlotAndTagInfo visibleStartY = " + i3 + " visibleEndY = " + i4 + " endSlotIndex = " + i10, new Object[0]);
    }

    private void j0() {
        int i2;
        int i3 = this.m;
        int i4 = this.f6516j + i3;
        int i5 = this.b;
        us.pinguo.common.log.a.k("updateCurPageInfo mVisibleSlotStart = " + this.b + " mVisibleSlotEnd = " + this.c, new Object[0]);
        int i6 = this.b;
        a.C0242a c0242a = null;
        while (true) {
            i2 = this.c;
            if (i6 >= i2) {
                break;
            }
            a.C0242a c0242a2 = this.p.get(i6);
            if (c0242a2 == null) {
                q(i6, null);
                c0242a2 = this.p.get(i6);
            }
            if (c0242a != null) {
                int i7 = c0242a2.a.bottom;
                Rect rect = c0242a.a;
                if (i7 != rect.bottom) {
                    int i8 = i6 - i5;
                    b bVar = new b(i6 - i8, rect);
                    bVar.a(i8);
                    this.C.a().add(bVar);
                    i5 = i6;
                }
            }
            i6++;
            c0242a = c0242a2;
        }
        c cVar = this.C;
        cVar.c = this.b;
        cVar.f6519d = i2;
        if (i5 != i2) {
            us.pinguo.common.log.a.k("updateCurPageInfo mSlotPositions size = " + this.p.size(), new Object[0]);
            int i9 = this.c + (-1);
            a.C0242a c0242a3 = this.p.get(i9);
            if (c0242a3 == null) {
                q(i9, null);
                c0242a3 = this.p.get(i9);
            }
            b bVar2 = new b(i5, c0242a3.a);
            bVar2.a(this.c - i5);
            this.C.a().add(bVar2);
        }
        for (int i10 = this.q; i10 < this.r; i10++) {
            y.c cVar2 = this.v.get(i10);
            us.pinguo.common.log.a.k("updateCurPageInfo cur tag curTag.pos.bottom= " + cVar2.f6396h.bottom, new Object[0]);
            int i11 = cVar2.f6396h.bottom;
            if (i11 < i3 || i11 > i4) {
                break;
            }
            us.pinguo.common.log.a.k("updateCurPageInfo cur tag rect 111= " + cVar2.f6396h.bottom + " mVisibleTagStart = " + this.q + " mVisibleTagEnd = " + this.r, new Object[0]);
            this.C.b().add(new b(i10, cVar2.f6396h));
        }
        us.pinguo.common.log.a.k("updateCurPageInfo visibleStartY = " + i3 + " visibleEndY -= " + i4 + " startSlotIndex = 0 endSlotIndex = 0", new Object[0]);
    }

    private void k0() {
        Rect rect;
        Rect rect2;
        ArrayList<b> a2 = this.C.a();
        ArrayList<b> a3 = this.D.a();
        int i2 = this.I;
        int i3 = 0;
        while (i3 < a2.size()) {
            b bVar = a2.get(i3);
            b bVar2 = i3 < a3.size() ? a3.get(i3) : null;
            if (bVar2 != null) {
                int i4 = bVar.a;
                int i5 = bVar.c + i4;
                while (i4 < i5) {
                    if (i4 == bVar.a) {
                        Rect rect3 = bVar2.b;
                        rect2 = new Rect(0, rect3.top, this.y, rect3.bottom);
                    } else {
                        Rect rect4 = this.C.f6521f.get(i4 - 1).a;
                        int i6 = rect4.right;
                        int i7 = rect4.top;
                        int i8 = this.y;
                        rect2 = new Rect(i6 + i2, i7, i6 + i2 + i8, i7 + i2 + i8);
                    }
                    this.C.f6521f.put(i4, new a.C0242a(false, rect2));
                    i4++;
                }
            } else {
                int i9 = bVar.a;
                int i10 = bVar.c + i9;
                while (i9 < i10) {
                    Rect rect5 = this.C.f6521f.get(i9 - 1).a;
                    if (i9 == bVar.a) {
                        int i11 = rect5.bottom + i2;
                        int i12 = this.y;
                        rect = new Rect(0, i11, i12, i11 + i12);
                    } else {
                        int i13 = rect5.right;
                        int i14 = rect5.top;
                        int i15 = this.y;
                        rect = new Rect(i13 + i2, i14, i13 + i2 + i15, i14 + i2 + i15);
                    }
                    this.C.f6521f.put(i9, new a.C0242a(false, rect));
                    i9++;
                }
            }
            i3++;
        }
    }

    private void l0() {
        r0();
        int[] p0 = p0(this.v, this.f6517k, true);
        M(p0[0], p0[1]);
    }

    private void m0() {
        int i2;
        int i3;
        int i4;
        int size = this.C.a().size();
        int size2 = this.D.a().size();
        int i5 = this.D.c;
        int i6 = this.f6511e + this.f6513g;
        int i7 = 0;
        while (i7 < size2) {
            b bVar = this.D.a().get(i7);
            b bVar2 = i7 <= size + (-1) ? this.C.a().get(i7) : null;
            if (bVar2 != null) {
                Rect rect = bVar2.b;
                int i8 = rect.top;
                int i9 = rect.bottom;
                int i10 = 0;
                while (true) {
                    i4 = bVar.c;
                    if (i10 >= i4) {
                        break;
                    }
                    int i11 = i10 * i6;
                    this.D.f6520e.put(i5 + i10, new a.C0242a(false, new Rect(i11, i8, this.f6511e + i11, i9)));
                    i10++;
                    size = size;
                }
                i2 = size;
                i5 += i4;
            } else {
                i2 = size;
                int i12 = this.D.f6520e.get(i5 - 1).a.bottom;
                int i13 = this.f6512f + i12;
                int i14 = 0;
                while (true) {
                    i3 = bVar.c;
                    if (i14 >= i3) {
                        break;
                    }
                    int i15 = i14 * i6;
                    this.D.f6520e.put(i5 + i14, new a.C0242a(false, new Rect(i15, i12, this.f6511e + i15, i13)));
                    i14++;
                }
                i5 += i3;
            }
            i7++;
            size = i2;
        }
    }

    private void n0() {
        int[] b2 = com.pinguo.camera360.gallery.ui.b0.a.b(this.x, this.n, this.f6516j);
        g0(b2[0], b2[1]);
    }

    private void o0() {
        n0();
        int[] p0 = p0(this.x, this.B, false);
        f0(p0[0], p0[1]);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01bb A[LOOP:0: B:12:0x005b->B:42:0x01bb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x011a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] p0(java.util.ArrayList<com.pinguo.camera360.gallery.data.y.c> r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.gallery.ui.b0.g.p0(java.util.ArrayList, int, boolean):int[]");
    }

    private void q0() {
        for (int i2 = 0; i2 < this.C.b().size(); i2++) {
            b bVar = this.C.b().get(i2);
            if (i2 > this.D.b().size() - 1) {
                bVar.b(false);
            } else if (bVar.b.top == this.D.b().get(i2).b.top) {
                bVar.b(true);
            } else {
                bVar.b(false);
            }
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void D() {
        this.b = 0;
        this.c = 0;
        z.f fVar = this.f6514h;
        int i2 = fVar.f6710e;
        this.f6513g = fVar.a;
        if (this.f6515i == 0) {
            this.f6515i = us.pinguo.foundation.t.b.a.j(us.pinguo.foundation.e.b());
            float dimension = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.album_padding_top);
            this.f6516j = (int) ((us.pinguo.foundation.t.b.a.h(us.pinguo.foundation.e.b()) - dimension) - us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.album_padding_bottom));
        }
        int max = (int) Math.max(1.0f, ((this.f6515i - ((i2 - 1) * this.f6513g)) / i2) + 0.5f);
        this.f6511e = max;
        if (this.v == null) {
            this.f6512f = this.f6514h.f6711f + max;
        } else {
            this.f6512f = max;
        }
        this.f6517k = i2;
        z.e eVar = this.a;
        if (eVar != null) {
            eVar.j(max, this.f6512f);
        }
        d0(this.f6516j, this.f6515i);
        r0();
        int[] p0 = p0(this.v, this.f6517k, true);
        M(p0[0], p0[1]);
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void F(int i2) {
        int i3 = this.J;
        if (i3 == 2) {
            return;
        }
        if (i3 == 0) {
            if (this.m == i2) {
                return;
            }
            this.m = i2;
            l0();
            int x = g(this.b, null).top - x();
            this.n = x;
            if (x <= this.f6514h.f6711f + this.I) {
                this.n = 0;
            }
            int i4 = this.A - this.f6516j;
            int i5 = i4 >= 0 ? i4 : 0;
            if (this.n > i5) {
                this.n = i5;
            }
            o0();
        } else if (i3 == 1) {
            if (this.n == i2) {
                return;
            }
            this.n = i2;
            int i6 = this.A - this.f6516j;
            if (i6 < 0) {
                i6 = 0;
            }
            if (i2 > i6) {
                this.n = i6;
            }
            o0();
            int i7 = q(this.G, null).top;
            this.m = i7;
            this.m = com.pinguo.album.j.a.e(i7, 0, this.f6518l - this.f6516j);
            l0();
        }
        h0();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public synchronized void G(int i2, int i3) {
        this.f6515i = i2;
        this.f6516j = i3;
        us.pinguo.common.log.a.k("setSize mWidth =" + this.f6515i + " mHeight= " + this.f6516j, new Object[0]);
        D();
        b0();
        h0();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public synchronized boolean H(int i2) {
        if (i2 == this.f6510d) {
            return false;
        }
        us.pinguo.common.log.a.k("---------setSlotCount ,with slotCount:" + i2, new Object[0]);
        this.f6510d = i2;
        D();
        b0();
        h0();
        return false;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void K(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3) {
        this.v = arrayList;
        this.x = arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void M(int i2, int i3) {
        if (i2 == this.b && i3 == this.c) {
            return;
        }
        if (i2 < i3) {
            if (i3 - i2 > l()) {
                i3 = l() + i2;
            }
            this.b = i2;
            this.c = i3;
        } else {
            this.c = 0;
            this.b = 0;
        }
        us.pinguo.common.log.a.c("setVisibleRange:" + this.b + "," + this.c, new Object[0]);
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public void O(float f2, float f3) {
        h0();
        this.C = new c();
        this.D = new c();
        j0();
        i0();
        m0();
        q0();
        k0();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    protected void P() {
    }

    public int R() {
        int i2 = this.J;
        if (i2 == 0) {
            return this.m;
        }
        if (i2 == 1) {
            return this.n;
        }
        return this.m;
    }

    public ArrayList<y.c> S() {
        return this.x;
    }

    public int T() {
        return this.H;
    }

    public int U() {
        return this.G;
    }

    public int V() {
        return this.F;
    }

    public int W() {
        return this.E;
    }

    protected void d0(int i2, int i3) {
        SparseArray<a.C0242a> sparseArray = this.p;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        ArrayList<y.c> arrayList = this.v;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int i4 = this.f6512f;
        int i5 = this.f6513g;
        int i6 = i4 + i5;
        e0(this.v, i6, i5);
        ArrayList<y.c> arrayList2 = this.v;
        int i7 = arrayList2.get(arrayList2.size() - 1).f6395g;
        ArrayList<y.c> arrayList3 = this.v;
        int i8 = arrayList3.get(arrayList3.size() - 1).f6396h.bottom + (i7 * i6);
        this.f6518l = i8;
        int i9 = this.t;
        if (i9 > 0) {
            this.f6518l = i8 + i9;
        }
        us.pinguo.common.log.a.k("mContentLength 1111 " + this.f6518l, new Object[0]);
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect f(int i2, Rect rect) {
        Rect rect2;
        ArrayList<b> a2;
        c cVar = this.D;
        if (cVar != null && (a2 = cVar.a()) != null) {
            c cVar2 = this.D;
            if (i2 >= cVar2.c && i2 <= cVar2.f6519d) {
                Iterator<b> it = a2.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    int i3 = next.a;
                    if (i2 >= i3 && i2 <= (i3 + next.c) - 1) {
                        rect2 = this.D.f6520e.get(i2).a;
                        break;
                    }
                }
            }
        }
        rect2 = null;
        if (rect2 != null) {
            return rect2;
        }
        Rect Q = Q(i2, this.x, this.B, this.y, this.I, this.E, this.F);
        if (Q == null) {
            return rect;
        }
        this.w.put(i2, new a.C0242a(false, Q));
        return Q;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect g(int i2, Rect rect) {
        a.C0242a c0242a;
        Rect rect2 = null;
        if (this.w.size() > 0 && (c0242a = this.w.get(i2)) != null) {
            rect2 = c0242a.a;
        }
        if (rect2 != null) {
            if (rect != null) {
                rect.set(rect2);
                return rect;
            }
            return rect2;
        }
        Rect Q = Q(i2, this.x, this.B, this.y, this.I, this.E, this.F);
        if (Q == null) {
            return rect;
        }
        us.pinguo.common.log.a.k("getFinalSlotPositionRect slotRect 222 = " + Q.toString() + " index = " + i2, new Object[0]);
        this.w.put(i2, new a.C0242a(false, Q));
        if (rect != null) {
            rect.set(Q);
            return rect;
        }
        return Q;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public List<Integer> h(float f2, float f3) {
        int i2 = this.J;
        if (i2 == 0) {
            return X(this.v, this.f6512f + this.f6513g, this.f6517k, this.m, f3);
        }
        if (i2 == 1) {
            return X(this.x, this.z + this.I, this.B, this.n, f3);
        }
        return null;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect i(int i2, Rect rect) {
        a.C0242a c0242a;
        c cVar = this.C;
        Rect rect2 = (cVar == null || (c0242a = cVar.f6521f.get(i2)) == null) ? null : c0242a.a;
        return rect2 != null ? rect2 : rect;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public int j() {
        if (this.J == 1) {
            int i2 = this.A - this.f6516j;
            if (i2 <= 0) {
                return 0;
            }
            return i2;
        }
        return super.j();
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public int n() {
        int i2;
        int i3;
        int i4 = this.J;
        if (i4 == 0) {
            i2 = this.f6512f;
            i3 = this.f6513g;
        } else if (i4 == 1) {
            i2 = this.z;
            i3 = this.I;
        } else {
            return this.f6512f;
        }
        return i2 + i3;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public int o(float f2, float f3) {
        int i2 = this.J;
        if (i2 == 0) {
            return Y(this.v, this.f6512f + this.f6513g, this.f6517k, this.m, this.f6518l, f2, f3);
        }
        if (i2 == 1) {
            return Y(this.x, this.z + this.I, this.B, this.n, this.A, f2, f3);
        }
        return -1;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public SparseArray<a.C0242a> p() {
        int i2 = this.J;
        if (i2 == 0) {
            return this.p;
        }
        if (i2 == 1) {
            return this.w;
        }
        return this.p;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public Rect q(int i2, Rect rect) {
        a.C0242a c0242a;
        Rect rect2 = null;
        if (this.p.size() > 0 && (c0242a = this.p.get(i2)) != null) {
            rect2 = c0242a.a;
        }
        if (rect2 == null) {
            rect2 = Q(i2, this.v, this.f6517k, this.f6511e, this.f6513g, this.q, this.r);
            if (rect2 == null) {
                return rect;
            }
            this.p.put(i2, new a.C0242a(false, rect2));
        }
        if (rect != null) {
            rect.set(rect2);
            return rect;
        }
        return rect2;
    }

    protected void r0() {
        int[] b2 = com.pinguo.camera360.gallery.ui.b0.a.b(this.v, this.m, this.f6516j);
        N(b2[0], b2[1]);
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public ArrayList<y.c> u() {
        int i2 = this.J;
        if (i2 == 0) {
            return this.v;
        }
        if (i2 == 1) {
            return this.x;
        }
        return this.v;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public y.c v(float f2, float f3) {
        y.c cVar = null;
        if (this.J == 0 && this.v != null) {
            int round = Math.round(f3) + this.m;
            int i2 = 0;
            int size = this.v.size() - 1;
            int i3 = this.f6512f + this.f6513g;
            while (i2 <= size) {
                int i4 = (i2 + size) >>> 1;
                y.c cVar2 = this.v.get(i4);
                Rect rect = cVar2.f6396h;
                int i5 = rect.top;
                if (round < i5 || round > rect.bottom) {
                    int i6 = rect.bottom;
                    if (i5 > round) {
                        size = i4 - 1;
                    } else if (i6 + (cVar2.f6395g * i3) < round) {
                        i2 = i4 + 1;
                    }
                    cVar = cVar2;
                }
                return cVar2;
            }
            return cVar;
        }
        return null;
    }

    @Override // com.pinguo.camera360.gallery.ui.b0.a
    public int w(float f2, float f3) {
        int i2 = this.J;
        if (i2 == 0) {
            return Z(f2, f3, this.v, this.m);
        }
        if (i2 == 1) {
            return Z(f2, f3, this.x, this.n);
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
