package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.jvm.internal.z.a;
/* compiled from: SparseArray.kt */
/* loaded from: classes.dex */
public final class SparseArrayKt$valueIterator$1 implements Iterator<T>, a {
    final /* synthetic */ SparseArray<T> $this_valueIterator;
    private int index;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.$this_valueIterator = sparseArray;
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
        SparseArray<T> sparseArray = this.$this_valueIterator;
        int i2 = this.index;
        this.index = i2 + 1;
        return sparseArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }
}
