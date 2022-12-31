package com.tapjoy.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes3.dex */
public final class az extends AbstractMap {
    private final HashMap a = new HashMap();
    private final bx b = new bx();

    private static Object a(bw bwVar) {
        if (bwVar != null) {
            return bwVar.get();
        }
        return null;
    }

    private void b() {
        while (true) {
            bw a = this.b.a();
            if (a == null) {
                return;
            }
            this.a.remove(a.a);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.a.clear();
        do {
        } while (this.b.a() != null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        b();
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        b();
        for (bw bwVar : this.a.values()) {
            if (obj.equals(bwVar.get())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        b();
        return a((bw) this.a.get(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        b();
        return this.a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        return a((bw) this.a.put(obj, new bw(obj, obj2, this.b)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        return a((bw) this.a.remove(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        b();
        return this.a.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        b();
        throw new UnsupportedOperationException();
    }

    public static az a() {
        return new az();
    }
}
