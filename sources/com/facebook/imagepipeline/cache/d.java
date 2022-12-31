package com.facebook.imagepipeline.cache;

import java.util.LinkedHashSet;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: BoundedLinkedHashSet.java */
@ThreadSafe
/* loaded from: classes.dex */
public class d<E> {
    private int a;
    private LinkedHashSet<E> b;

    public d(int i2) {
        this.b = new LinkedHashSet<>(i2);
        this.a = i2;
    }

    public synchronized boolean a(E e2) {
        if (this.b.size() == this.a) {
            LinkedHashSet<E> linkedHashSet = this.b;
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        this.b.remove(e2);
        return this.b.add(e2);
    }

    public synchronized boolean b(E e2) {
        return this.b.contains(e2);
    }
}
