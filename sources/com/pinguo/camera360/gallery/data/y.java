package com.pinguo.camera360.gallery.data;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* compiled from: MediaSet.java */
/* loaded from: classes3.dex */
public abstract class y extends x {

    /* renamed from: e  reason: collision with root package name */
    private static final com.pinguo.album.c<Integer> f6390e = new a();

    /* renamed from: d  reason: collision with root package name */
    private WeakHashMap<n, Object> f6391d;

    /* compiled from: MediaSet.java */
    /* loaded from: classes3.dex */
    class a implements com.pinguo.album.c<Integer> {
        a() {
        }

        @Override // com.pinguo.album.c
        /* renamed from: a */
        public Integer get() {
            return 0;
        }

        @Override // com.pinguo.album.c
        public void cancel() {
        }

        @Override // com.pinguo.album.c, com.pinguo.album.a.c
        public boolean isCancelled() {
            return false;
        }
    }

    /* compiled from: MediaSet.java */
    /* loaded from: classes3.dex */
    public static class b {
        public float a;
        public int b;
        public int c;
    }

    /* compiled from: MediaSet.java */
    /* loaded from: classes3.dex */
    public static class c {
        public long a;
        public String b;

        /* renamed from: e  reason: collision with root package name */
        public int f6393e;

        /* renamed from: g  reason: collision with root package name */
        public int f6395g;

        /* renamed from: h  reason: collision with root package name */
        public Rect f6396h;

        /* renamed from: j  reason: collision with root package name */
        public int f6398j;
        public String c = "";

        /* renamed from: d  reason: collision with root package name */
        public int f6392d = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f6394f = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f6397i = false;

        /* renamed from: k  reason: collision with root package name */
        public int f6399k = 0;

        public String toString() {
            return "tag {index:" + this.f6392d + ",tagName:" + this.c + ",timeLong:" + this.a + ",slotCount:" + this.f6393e + ",contentRows:" + this.f6395g + "}";
        }
    }

    /* compiled from: MediaSet.java */
    /* loaded from: classes3.dex */
    public interface d {
        void r(y yVar, int i2);
    }

    public y(Path path, long j2) {
        super(path, j2);
        this.f6391d = new WeakHashMap<>();
    }

    public void A() {
    }

    public void B(long j2, long j3) {
    }

    public void k(n nVar) {
        if (this.f6391d.containsKey(nVar)) {
            return;
        }
        this.f6391d.put(nVar, null);
    }

    public int l(ArrayList<c> arrayList) {
        return 0;
    }

    public int m(ArrayList<c> arrayList, ArrayList<b> arrayList2) {
        return 0;
    }

    public int n(ArrayList<c> arrayList, ArrayList<c> arrayList2) {
        return 0;
    }

    public w o() {
        ArrayList<w> q = q(0, 1);
        if (q.size() > 0) {
            return q.get(0);
        }
        int u = u();
        for (int i2 = 0; i2 < u; i2++) {
            w o = t(i2).o();
            if (o != null) {
                return o;
            }
        }
        return null;
    }

    public abstract ArrayList<m> p(int i2, int i3);

    public abstract ArrayList<w> q(int i2, int i3);

    public int r() {
        return 0;
    }

    public abstract String s();

    public y t(int i2) {
        throw new IndexOutOfBoundsException();
    }

    public int u() {
        return 0;
    }

    public boolean v() {
        return false;
    }

    public void w() {
        for (n nVar : this.f6391d.keySet()) {
            nVar.a();
        }
    }

    public abstract long x();

    public void y(n nVar) {
        if (this.f6391d.containsKey(nVar)) {
            this.f6391d.remove(nVar);
        }
    }

    public com.pinguo.album.c<Integer> z(d dVar) {
        dVar.r(this, 0);
        return f6390e;
    }
}
