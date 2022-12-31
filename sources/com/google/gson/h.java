package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* loaded from: classes2.dex */
public final class h extends k implements Iterable<k> {
    private final List<k> a = new ArrayList();

    @Override // com.google.gson.k
    public int a() {
        if (this.a.size() == 1) {
            return this.a.get(0).a();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void i(k kVar) {
        if (kVar == null) {
            kVar = l.a;
        }
        this.a.add(kVar);
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.a.iterator();
    }

    public void j(String str) {
        this.a.add(str == null ? l.a : new n(str));
    }
}
