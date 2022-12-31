package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes3.dex */
final class en extends AbstractList implements Serializable, RandomAccess {
    private final ArrayList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(List list) {
        this.a = new ArrayList(list);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.a.get(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return this.a.toArray();
    }
}
