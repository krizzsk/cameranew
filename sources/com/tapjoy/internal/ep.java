package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes3.dex */
final class ep extends AbstractList implements Serializable, RandomAccess {
    List a;
    private final List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(List list) {
        this.b = list;
        this.a = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        if (this.a == this.b) {
            this.a = new ArrayList(this.b);
        }
        this.a.add(i2, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        if (this.a == this.b) {
            this.a = new ArrayList(this.b);
        }
        return this.a.remove(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        if (this.a == this.b) {
            this.a = new ArrayList(this.b);
        }
        return this.a.set(i2, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }
}
