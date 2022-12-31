package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.i0;
/* compiled from: ArrayIterators.kt */
/* loaded from: classes3.dex */
final class j extends i0 {
    private final long[] a;
    private int b;

    public j(long[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // kotlin.collections.i0
    public long nextLong() {
        try {
            long[] jArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return jArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
