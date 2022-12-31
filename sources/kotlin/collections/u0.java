package kotlin.collections;

import java.util.Iterator;
/* compiled from: Iterators.kt */
/* loaded from: classes3.dex */
public abstract class u0 implements Iterator<Short>, kotlin.jvm.internal.z.a {
    public abstract short a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
