package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.u0;
/* compiled from: ArrayIterators.kt */
/* loaded from: classes3.dex */
final class k extends u0 {
    private final short[] a;
    private int b;

    public k(short[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.u0
    public short a() {
        try {
            short[] sArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return sArr[i2];
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
