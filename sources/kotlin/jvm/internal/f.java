package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.h0;
/* compiled from: ArrayIterators.kt */
/* loaded from: classes3.dex */
final class f extends h0 {
    private final int[] a;
    private int b;

    public f(int[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // kotlin.collections.h0
    public int nextInt() {
        try {
            int[] iArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return iArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
