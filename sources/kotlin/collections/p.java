package kotlin.collections;

import java.util.Iterator;
/* compiled from: Iterators.kt */
/* loaded from: classes3.dex */
public abstract class p implements Iterator<Boolean>, kotlin.jvm.internal.z.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }

    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
