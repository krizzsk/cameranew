package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* compiled from: ArrayIterators.kt */
/* loaded from: classes3.dex */
final class c extends kotlin.collections.r {
    private final char[] a;
    private int b;

    public c(char[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.r
    public char a() {
        try {
            char[] cArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return cArr[i2];
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
