package com.facebook.imagepipeline.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: CountingLruMap.java */
@ThreadSafe
/* loaded from: classes.dex */
public class h<K, V> {
    private final v<V> a;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> b = new LinkedHashMap<>();
    @GuardedBy("this")
    private int c = 0;

    public h(v<V> vVar) {
        this.a = vVar;
    }

    private int f(@Nullable V v) {
        if (v == null) {
            return 0;
        }
        return this.a.a(v);
    }

    public synchronized boolean a(K k2) {
        return this.b.containsKey(k2);
    }

    @Nullable
    public synchronized V b(K k2) {
        return this.b.get(k2);
    }

    public synchronized int c() {
        return this.b.size();
    }

    @Nullable
    public synchronized K d() {
        return this.b.isEmpty() ? null : this.b.keySet().iterator().next();
    }

    public synchronized int e() {
        return this.c;
    }

    @Nullable
    public synchronized V g(K k2, V v) {
        V remove;
        remove = this.b.remove(k2);
        this.c -= f(remove);
        this.b.put(k2, v);
        this.c += f(v);
        return remove;
    }

    @Nullable
    public synchronized V h(K k2) {
        V remove;
        remove = this.b.remove(k2);
        this.c -= f(remove);
        return remove;
    }

    public synchronized ArrayList<V> i(@Nullable com.facebook.common.internal.i<K> iVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (iVar == null || iVar.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.c -= f(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }
}
