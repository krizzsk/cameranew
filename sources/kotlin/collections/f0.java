package kotlin.collections;

import java.util.Iterator;
/* compiled from: Iterators.kt */
/* loaded from: classes3.dex */
public abstract class f0 implements Iterator<Float>, kotlin.jvm.internal.z.a {
    public abstract float a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Float next() {
        return Float.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
