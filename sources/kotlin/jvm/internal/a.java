package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* compiled from: ArrayIterators.kt */
/* loaded from: classes3.dex */
final class a extends kotlin.collections.p {
    private final boolean[] a;
    private int b;

    public a(boolean[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // kotlin.collections.p
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return zArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
