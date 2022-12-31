package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.jvm.internal.z.a;
/* compiled from: LongSparseArray.kt */
/* loaded from: classes.dex */
public final class LongSparseArrayKt$valueIterator$1 implements Iterator<T>, a {
    final /* synthetic */ LongSparseArray<T> $this_valueIterator;
    private int index;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongSparseArrayKt$valueIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_valueIterator = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @Override // java.util.Iterator
    public T next() {
        LongSparseArray<T> longSparseArray = this.$this_valueIterator;
        int i2 = this.index;
        this.index = i2 + 1;
        return longSparseArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }
}
