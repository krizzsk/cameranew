package com.pinguo.camera360.gallery.ui.b0;

import android.graphics.Rect;
import android.util.SparseArray;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.l;
import com.pinguo.camera360.gallery.ui.z;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseSlotLayout.java */
/* loaded from: classes3.dex */
public abstract class a {
    protected z.e a;
    protected int b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected int f6510d;

    /* renamed from: e  reason: collision with root package name */
    protected int f6511e;

    /* renamed from: f  reason: collision with root package name */
    protected int f6512f;

    /* renamed from: g  reason: collision with root package name */
    protected int f6513g;

    /* renamed from: h  reason: collision with root package name */
    protected z.f f6514h;

    /* renamed from: i  reason: collision with root package name */
    protected int f6515i;

    /* renamed from: j  reason: collision with root package name */
    protected int f6516j;

    /* renamed from: k  reason: collision with root package name */
    protected int f6517k;

    /* renamed from: l  reason: collision with root package name */
    protected int f6518l;
    protected int m;
    protected int n;
    protected ArrayList<y.c> o;
    protected SparseArray<C0242a> p = new SparseArray<>();
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected int u;

    /* compiled from: BaseSlotLayout.java */
    /* renamed from: com.pinguo.camera360.gallery.ui.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0242a {
        public Rect a;

        public C0242a(boolean z, Rect rect) {
            this.a = rect;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int[] b(ArrayList<y.c> arrayList, int i2, int i3) {
        boolean z;
        if (arrayList == null || arrayList.size() == 0) {
            return new int[]{0, 0};
        }
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        while (true) {
            if (i4 >= arrayList.size()) {
                z = false;
                i4 = 0;
                break;
            }
            y.c cVar = arrayList.get(i4);
            if (!z2 && cVar.f6396h.bottom >= i2) {
                i5 = i4;
                z2 = true;
            }
            if (z2 && cVar.f6396h.top >= i2 + i3) {
                z = true;
                break;
            }
            i4++;
        }
        if (!z2) {
            i4 = arrayList.size();
            i5 = i4;
        } else if (!z) {
            i4 = arrayList.size();
        }
        return new int[]{i5, i4};
    }

    public static a c(int i2) {
        return d(i2, 0);
    }

    public static a d(int i2, int i3) {
        a eVar;
        if (i2 == 0) {
            eVar = new c();
        } else if (i2 == 1) {
            eVar = new f();
        } else if (i2 == 2) {
            eVar = new g();
        } else if (i2 == 3) {
            eVar = new b();
        } else if (i2 == 4) {
            eVar = new d();
        } else if (i2 == 5) {
            eVar = new e();
        } else {
            throw new IllegalArgumentException("slot type not defined");
        }
        eVar.E(i3);
        eVar.s = i2;
        return eVar;
    }

    public int A() {
        return this.b;
    }

    public int B() {
        return this.r;
    }

    public int C() {
        return this.q;
    }

    protected abstract void D();

    public void E(int i2) {
        this.t = i2;
    }

    public void F(int i2) {
        if (this.m == i2) {
            return;
        }
        this.m = i2;
        P();
    }

    public void G(int i2, int i3) {
        this.f6515i = i2;
        this.f6516j = i3;
        D();
    }

    public boolean H(int i2) {
        if (i2 == this.f6510d) {
            return false;
        }
        us.pinguo.common.log.a.k("---------setSlotCount ,with slotCount:" + i2, new Object[0]);
        this.f6510d = i2;
        D();
        return false;
    }

    public void I(z.e eVar) {
        this.a = eVar;
    }

    public void J(z.f fVar) {
        this.f6514h = fVar;
    }

    public void K(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3) {
        this.o = arrayList;
    }

    public void L(int i2) {
        this.u = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i2, int i3) {
        us.pinguo.common.log.a.k("setVisibleRange start = " + i2 + " end = " + i3 + " mVisibleSlotStart  = " + this.b + " mVisibleSlotEnd = " + this.c + "mSlotCount = " + this.f6510d, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("setVisibleRange mContentLength = ");
        sb.append(this.f6518l);
        us.pinguo.common.log.a.k(sb.toString(), new Object[0]);
        if (i2 == this.b && i3 == this.c) {
            return;
        }
        if (i2 < i3) {
            this.b = i2;
            this.c = i3;
        } else {
            this.c = 0;
            this.b = 0;
        }
        z.e eVar = this.a;
        if (eVar != null) {
            eVar.d(this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(int i2, int i3) {
        if (i2 == this.q && i3 == this.r) {
            return;
        }
        if (i2 <= i3) {
            this.q = i2;
            this.r = i3;
        }
        z.e eVar = this.a;
        if (eVar != null) {
            eVar.i(this.q, this.r, l.o);
        }
    }

    public abstract void O(float f2, float f3);

    protected abstract void P();

    public boolean a(long j2) {
        return false;
    }

    public int e() {
        return this.n;
    }

    public abstract Rect f(int i2, Rect rect);

    public abstract Rect g(int i2, Rect rect);

    public List<Integer> h(float f2, float f3) {
        return null;
    }

    public abstract Rect i(int i2, Rect rect);

    public int j() {
        int i2 = this.f6518l - this.f6516j;
        if (i2 <= 0) {
            return 0;
        }
        return i2;
    }

    public int k() {
        return this.m;
    }

    public int l() {
        return 96;
    }

    public int m() {
        return this.f6510d;
    }

    public int n() {
        return this.f6512f;
    }

    public abstract int o(float f2, float f3);

    public SparseArray<C0242a> p() {
        return this.p;
    }

    public abstract Rect q(int i2, Rect rect);

    public z.f r() {
        return this.f6514h;
    }

    public int s() {
        return this.s;
    }

    public int t() {
        return this.f6511e;
    }

    public ArrayList<y.c> u() {
        return this.o;
    }

    public y.c v(float f2, float f3) {
        return null;
    }

    public int w(float f2, float f3) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int x() {
        return this.u + this.f6514h.m;
    }

    public abstract float[] y(int i2, float f2, float f3);

    public int z() {
        return this.c;
    }
}
