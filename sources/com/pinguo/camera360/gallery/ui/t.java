package com.pinguo.camera360.gallery.ui;

import android.util.SparseArray;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.b0.a;
import com.pinguo.camera360.gallery.ui.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
/* compiled from: PhotoSelector.java */
/* loaded from: classes3.dex */
public class t implements o {
    private ArrayList<y.c> a;
    private SparseArray<a.C0242a> b;
    private com.pinguo.camera360.gallery.data.y c;

    /* renamed from: d  reason: collision with root package name */
    private o.a f6642d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6643e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6644f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Integer, Path> f6645g = new HashMap<>();

    public t(com.pinguo.camera360.gallery.l lVar, boolean z) {
        lVar.P();
    }

    private y.c l(int i2) {
        ArrayList<y.c> arrayList;
        if (this.b == null || (arrayList = this.a) == null) {
            return null;
        }
        int i3 = 0;
        int size = arrayList.size();
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            y.c cVar = this.a.get(i4);
            int i5 = cVar.f6392d;
            if (i5 > i2) {
                size = i4;
            } else if (i5 + cVar.f6393e > i2) {
                return cVar;
            } else {
                i3 = i4;
            }
        }
        return null;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void a(ArrayList<y.c> arrayList, SparseArray<a.C0242a> sparseArray) {
        this.a = arrayList;
        this.b = sparseArray;
        this.f6645g.clear();
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void b(Path path) {
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public int c() {
        if (this.b == null || this.a == null) {
            return 0;
        }
        return this.f6645g.size();
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void d(o.a aVar) {
        this.f6642d = aVar;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void e(Path path, boolean z) {
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void f() {
        this.f6644f = false;
        if (this.f6643e) {
            this.f6643e = false;
            o.a aVar = this.f6642d;
            if (aVar instanceof o.b) {
                ((o.b) aVar).h(false, this.f6645g.keySet());
            }
            p();
            this.f6645g.clear();
            o.a aVar2 = this.f6642d;
            if (aVar2 != null) {
                aVar2.s(2);
            }
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public ArrayList<Path> g(boolean z) {
        ArrayList<Path> arrayList = new ArrayList<>();
        if (this.f6644f) {
            int n = n();
            int i2 = 0;
            while (i2 < n) {
                int min = Math.min(n - i2, 500);
                Iterator<com.pinguo.camera360.gallery.data.m> it = this.c.p(i2, min).iterator();
                while (it.hasNext()) {
                    Path path = it.next().a;
                    if (!this.f6645g.containsValue(path)) {
                        arrayList.add(path);
                    }
                }
                i2 += min;
            }
        } else {
            arrayList.addAll(this.f6645g.values());
        }
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public boolean h(Path path, int i2) {
        if (this.f6644f) {
            return true;
        }
        HashMap<Integer, Path> hashMap = this.f6645g;
        if (hashMap == null || !this.f6643e) {
            return false;
        }
        return hashMap.containsKey(Integer.valueOf(i2));
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public boolean i() {
        return this.f6643e;
    }

    @Override // com.pinguo.camera360.gallery.ui.o
    public void j(com.pinguo.camera360.gallery.data.y yVar) {
        this.c = yVar;
    }

    public void k() {
        if (this.f6643e) {
            return;
        }
        this.f6643e = true;
        o.a aVar = this.f6642d;
        if (aVar != null) {
            aVar.s(1);
        }
    }

    public Set<Integer> m() {
        return this.f6645g.keySet();
    }

    public int n() {
        com.pinguo.camera360.gallery.data.y yVar = this.c;
        if (yVar == null) {
            return -1;
        }
        return yVar.r();
    }

    public void o(int i2) {
        ArrayList<y.c> arrayList = this.a;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        y.c l2 = l(i2);
        for (int i3 = (l2.f6392d + l2.f6393e) - 1; i3 >= l2.f6392d; i3--) {
            if (!this.f6645g.containsKey(Integer.valueOf(i3))) {
                l2.f6397i = false;
                return;
            }
        }
        l2.f6397i = true;
    }

    public void p() {
        ArrayList<y.c> arrayList;
        if (this.b == null || (arrayList = this.a) == null) {
            return;
        }
        Iterator<y.c> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().f6397i = false;
        }
    }

    public void q(int i2, Path path) {
        if (this.b == null || this.a == null) {
            return;
        }
        boolean z = !this.f6645g.containsKey(Integer.valueOf(i2));
        if (z) {
            this.f6645g.put(Integer.valueOf(i2), path);
            k();
        } else {
            this.f6645g.remove(Integer.valueOf(i2));
            if (this.f6644f) {
                this.f6644f = false;
                o.a aVar = this.f6642d;
                if (aVar != null) {
                    aVar.s(3);
                }
            }
        }
        o(i2);
        o.a aVar2 = this.f6642d;
        if (aVar2 != null) {
            if (aVar2 instanceof o.b) {
                ((o.b) aVar2).n(z, i2);
            }
            this.f6642d.l();
        }
    }

    public void r(int i2) {
        ArrayList<y.c> arrayList = this.a;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        y.c cVar = this.a.get(i2);
        boolean z = true;
        boolean z2 = !cVar.f6397i;
        cVar.f6397i = z2;
        if ((!z2 || this.f6644f) && (z2 || !this.f6644f)) {
            z = false;
        }
        if (z) {
            ArrayList<com.pinguo.camera360.gallery.data.m> p = this.c.p(cVar.f6392d, cVar.f6393e);
            if (p != null) {
                for (int i3 = cVar.f6392d; i3 < cVar.f6392d + cVar.f6393e; i3++) {
                    if (!this.f6645g.containsKey(Integer.valueOf(i3))) {
                        this.f6645g.put(Integer.valueOf(i3), p.get(i3 - cVar.f6392d).a);
                    }
                }
                k();
            }
        } else {
            for (int i4 = cVar.f6392d; i4 < cVar.f6392d + cVar.f6393e; i4++) {
                this.f6645g.remove(Integer.valueOf(i4));
            }
        }
        o.a aVar = this.f6642d;
        if (aVar != null) {
            aVar.l();
        }
    }
}
