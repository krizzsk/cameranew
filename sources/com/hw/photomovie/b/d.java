package com.hw.photomovie.b;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.hw.photomovie.b.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: PhotoSource.java */
/* loaded from: classes2.dex */
public class d implements b.a {

    /* renamed from: d  reason: collision with root package name */
    private a f5152d;

    /* renamed from: f  reason: collision with root package name */
    private int f5154f;
    private List<b> a = new Vector();
    private SparseArray<Float> b = new SparseArray<>();
    private Map<b, Integer> c = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private AtomicInteger f5153e = new AtomicInteger(0);

    /* compiled from: PhotoSource.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(d dVar, float f2);

        void b(d dVar, int i2, List<b> list);
    }

    public d(List<b> list) {
        if (list != null) {
            this.a.addAll(list);
        }
        this.f5153e.set(0);
    }

    private List<b> f() {
        ArrayList arrayList = new ArrayList(this.c.keySet());
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= arrayList.size() || size < 0) {
                break;
            }
            Integer num = this.c.get(arrayList.get(size));
            if (num == null || num.intValue() < 2) {
                arrayList.remove(size);
            }
        }
        return arrayList;
    }

    private synchronized void h() {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < k() && i2 < this.f5154f; i2++) {
            f2 += (this.b.get(e(i2).hashCode(), Float.valueOf(0.0f)).floatValue() * 1.0f) / this.f5154f;
        }
        a aVar = this.f5152d;
        if (aVar != null) {
            aVar.a(this, f2);
            if (this.f5153e.get() >= this.f5154f) {
                this.f5152d.b(this, this.f5153e.get(), f());
                for (int i3 = this.f5154f; i3 < k(); i3++) {
                    e(i3).prepareData(2, null);
                }
            }
        }
        com.hw.photomovie.util.b.c("PhotoSource", "onDownloadProgressUpdate:" + f2);
    }

    @Override // com.hw.photomovie.b.b.a
    public void a(b bVar) {
        this.f5153e.addAndGet(1);
        this.b.put(bVar.hashCode(), Float.valueOf(1.0f));
        h();
    }

    @Override // com.hw.photomovie.b.b.a
    public void b(b bVar, Bitmap bitmap) {
        h();
    }

    @Override // com.hw.photomovie.b.b.a
    public void c(b bVar, com.hw.photomovie.b.a aVar) {
        Integer valueOf = Integer.valueOf(this.c.containsKey(bVar) ? 1 + this.c.get(bVar).intValue() : 1);
        this.c.put(bVar, valueOf);
        if (valueOf.intValue() >= 2) {
            com.hw.photomovie.util.b.a("PhotoSource", bVar + " prepare error:" + valueOf + " 放弃加载。");
            this.a.remove(bVar);
            h();
            return;
        }
        bVar.prepareData(bVar.getTargetState(), this);
        com.hw.photomovie.util.b.a("PhotoSource", bVar + " prepare error:" + valueOf);
    }

    @Override // com.hw.photomovie.b.b.a
    public void d(b bVar, int i2, int i3) {
        if (bVar == null) {
            return;
        }
        this.b.put(bVar.hashCode(), Float.valueOf(i2 / i3));
        h();
    }

    public b e(int i2) {
        if (i2 < 0 || i2 >= this.a.size()) {
            return null;
        }
        return this.a.get(i2);
    }

    public List<b> g() {
        return new LinkedList(this.a);
    }

    public void i(int i2) {
        this.f5154f = i2;
        this.b.clear();
        if (k() == 0) {
            a aVar = this.f5152d;
            if (aVar != null) {
                aVar.a(this, 1.0f);
                this.f5152d.b(this, 0, null);
                return;
            }
            return;
        }
        this.a.addAll(this.c.keySet());
        this.c.clear();
        this.f5153e.set(0);
        for (int i3 = 0; i3 < k() && i3 < i2; i3++) {
            e(i3).prepareData(2, this);
        }
    }

    public void j(a aVar) {
        this.f5152d = aVar;
    }

    public int k() {
        return this.a.size();
    }
}
