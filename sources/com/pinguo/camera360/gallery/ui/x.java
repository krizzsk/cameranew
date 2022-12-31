package com.pinguo.camera360.gallery.ui;

import android.util.SparseArray;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.b0.a;
import com.pinguo.camera360.gallery.ui.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* compiled from: SelectionManager.java */
/* loaded from: classes3.dex */
public class x implements o {
    private Set<Path> a;
    private com.pinguo.camera360.gallery.data.y b;
    private o.a c;

    /* renamed from: d  reason: collision with root package name */
    private com.pinguo.camera360.gallery.data.o f6688d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6689e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6690f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6691g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6692h;

    /* renamed from: i  reason: collision with root package name */
    private int f6693i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6694j;

    public x(com.pinguo.camera360.gallery.l lVar, boolean z) {
        this(lVar, z, true);
    }

    private static void m(ArrayList<Path> arrayList, com.pinguo.camera360.gallery.data.y yVar) {
        int u = yVar.u();
        int i2 = 0;
        for (int i3 = 0; i3 < u; i3++) {
            m(arrayList, yVar.t(i3));
        }
        int r = yVar.r();
        while (i2 < r) {
            int i4 = i2 + 50;
            Iterator<com.pinguo.camera360.gallery.data.m> it = yVar.p(i2, i4 < r ? 50 : r - i2).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a);
            }
            i2 = i4;
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void a(ArrayList<y.c> arrayList, SparseArray<a.C0242a> sparseArray) {
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void b(Path path) {
        q(-1, path);
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public int c() {
        int size = this.a.size();
        us.pinguo.common.log.a.m("WQL", "mInverseSelection = " + this.f6689e + " getTotalCount = " + n() + " count = " + size, new Object[0]);
        return this.f6689e ? n() - size : size;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void d(o.a aVar) {
        this.c = aVar;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void e(Path path, boolean z) {
        if (!z) {
            this.a.remove(path);
        } else {
            l();
            this.a.add(path);
        }
        int c = c();
        if (c == n()) {
            o();
        }
        o.a aVar = this.c;
        if (aVar != null) {
            aVar.l();
        }
        if (c == 0 && this.f6692h) {
            f();
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void f() {
        if (this.f6691g) {
            this.f6691g = false;
            this.f6689e = false;
            this.a.clear();
            o.a aVar = this.c;
            if (aVar != null) {
                aVar.s(2);
            }
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public ArrayList<Path> g(boolean z) {
        ArrayList<Path> arrayList = new ArrayList<>();
        int i2 = 0;
        if (this.f6690f) {
            if (this.f6689e) {
                int n = n();
                us.pinguo.common.log.a.m("SelectionManager", "toatal =" + n, new Object[0]);
                while (i2 < n) {
                    com.pinguo.camera360.gallery.data.y t = this.b.t(i2);
                    Path g2 = t.g();
                    if (!this.a.contains(g2)) {
                        if (z) {
                            m(arrayList, t);
                        } else {
                            arrayList.add(g2);
                        }
                    }
                    i2++;
                }
            } else {
                for (Path path : this.a) {
                    if (z) {
                        m(arrayList, this.f6688d.e(path, ""));
                    } else {
                        arrayList.add(path);
                    }
                }
            }
        } else if (this.f6689e) {
            int n2 = n();
            while (i2 < n2) {
                int min = Math.min(n2 - i2, 500);
                Iterator<com.pinguo.camera360.gallery.data.m> it = this.b.p(i2, min).iterator();
                while (it.hasNext()) {
                    Path path2 = it.next().a;
                    if (!this.a.contains(path2)) {
                        arrayList.add(path2);
                    }
                }
                i2 += min;
            }
        } else {
            for (Path path3 : this.a) {
                arrayList.add(path3);
            }
        }
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public boolean h(Path path, int i2) {
        return this.a.contains(path) ^ this.f6689e;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public boolean i() {
        return this.f6691g;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void j(com.pinguo.camera360.gallery.data.y yVar) {
        this.b = yVar;
        this.f6693i = -1;
    }

    public void k() {
        if (this.f6694j) {
            this.f6691g = true;
            this.f6689e = false;
            this.a.clear();
            o.a aVar = this.c;
            if (aVar != null) {
                aVar.s(3);
            }
        }
    }

    public void l() {
        if (this.f6691g) {
            return;
        }
        this.f6691g = true;
        o.a aVar = this.c;
        if (aVar != null) {
            aVar.s(1);
        }
    }

    public int n() {
        com.pinguo.camera360.gallery.data.y yVar = this.b;
        if (yVar == null) {
            return -1;
        }
        if (this.f6693i < 0 || this.f6690f) {
            this.f6693i = this.f6690f ? yVar.u() : yVar.r();
        }
        return this.f6693i;
    }

    public void o() {
        if (this.f6694j) {
            this.f6689e = true;
            this.a.clear();
            l();
            o.a aVar = this.c;
            if (aVar != null) {
                aVar.s(3);
            }
        }
    }

    public void p(Path path) {
    }

    public void q(int i2, Path path) {
        boolean z;
        if (this.a.contains(path)) {
            this.a.remove(path);
            z = false;
        } else {
            l();
            this.a.add(path);
            z = true;
        }
        int c = c();
        if (c == n()) {
            o();
        }
        o.a aVar = this.c;
        if (aVar != null) {
            if (i2 >= 0 && (aVar instanceof o.b)) {
                ((o.b) aVar).n(z, i2);
            }
            this.c.l();
        }
        if (c == 0 && this.f6692h) {
            f();
        }
    }

    public x(com.pinguo.camera360.gallery.l lVar, boolean z, boolean z2) {
        this.f6692h = false;
        this.f6688d = lVar.P();
        this.a = new HashSet();
        this.f6690f = z;
        this.f6693i = -1;
        this.f6694j = z2;
    }
}
