package us.pinguo.picker.image.gallery;

import java.util.ArrayList;
import java.util.WeakHashMap;
/* compiled from: MediaSet.java */
/* loaded from: classes5.dex */
public abstract class o extends n {

    /* renamed from: d  reason: collision with root package name */
    private WeakHashMap<e, Object> f11718d;

    public o(Path path, long j2) {
        super(path, j2);
        this.f11718d = new WeakHashMap<>();
    }

    public void e(e eVar) {
        if (this.f11718d.containsKey(eVar)) {
            return;
        }
        this.f11718d.put(eVar, null);
    }

    public m f() {
        ArrayList<m> g2 = g(0, 1);
        if (g2.size() > 0) {
            return g2.get(0);
        }
        int k2 = k();
        for (int i2 = 0; i2 < k2; i2++) {
            m f2 = j(i2).f();
            if (f2 != null) {
                return f2;
            }
        }
        return null;
    }

    public abstract ArrayList<m> g(int i2, int i3);

    public int h() {
        return 0;
    }

    public abstract String i();

    public o j(int i2) {
        throw new IndexOutOfBoundsException();
    }

    public int k() {
        return 0;
    }

    public boolean l() {
        return false;
    }

    public void m() {
        for (e eVar : this.f11718d.keySet()) {
            eVar.a();
        }
    }

    public abstract long n();

    public void o(e eVar) {
        if (this.f11718d.containsKey(eVar)) {
            this.f11718d.remove(eVar);
        }
    }
}
