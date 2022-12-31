package kotlin.collections;

import java.util.Iterator;
/* compiled from: Iterators.kt */
/* loaded from: classes3.dex */
public abstract class r implements Iterator<Character>, kotlin.jvm.internal.z.a {
    public abstract char a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
