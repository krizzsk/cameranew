package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* compiled from: ArrayIterators.kt */
/* loaded from: classes3.dex */
final class b extends kotlin.collections.q {
    private final byte[] a;
    private int b;

    public b(byte[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // kotlin.collections.q
    public byte nextByte() {
        try {
            byte[] bArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return bArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
