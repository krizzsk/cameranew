package kotlin.collections;

import java.util.Collection;
/* compiled from: AbstractMutableCollection.kt */
/* loaded from: classes3.dex */
public abstract class d<E> extends java.util.AbstractCollection<E> implements Collection<E>, kotlin.jvm.internal.z.b {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
