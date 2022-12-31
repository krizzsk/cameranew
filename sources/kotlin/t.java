package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: UShortArray.kt */
/* loaded from: classes3.dex */
public final class t implements Collection<s>, kotlin.jvm.internal.z.a {

    /* compiled from: UShortArray.kt */
    /* loaded from: classes3.dex */
    private static final class a implements Iterator<s>, kotlin.jvm.internal.z.a {
        private final short[] a;
        private int b;

        public a(short[] array) {
            kotlin.jvm.internal.s.h(array, "array");
            this.a = array;
        }

        public short a() {
            int i2 = this.b;
            short[] sArr = this.a;
            if (i2 < sArr.length) {
                this.b = i2 + 1;
                short s = sArr[i2];
                s.b(s);
                return s;
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ s next() {
            return s.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static Iterator<s> a(short[] sArr) {
        return new a(sArr);
    }
}
