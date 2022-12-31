package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;
/* compiled from: AbstractMutableSet.kt */
/* loaded from: classes3.dex */
public abstract class g<E> extends AbstractSet<E> implements Set<E>, Object {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e2);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
