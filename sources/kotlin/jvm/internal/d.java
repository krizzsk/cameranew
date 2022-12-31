package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.d0;
/* compiled from: ArrayIterators.kt */
/* loaded from: classes3.dex */
final class d extends d0 {
    private final double[] a;
    private int b;

    public d(double[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.d0
    public double a() {
        try {
            double[] dArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return dArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
