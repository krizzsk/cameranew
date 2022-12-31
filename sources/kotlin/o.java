package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: UIntArray.kt */
/* loaded from: classes3.dex */
public final class o implements Collection<n>, kotlin.jvm.internal.z.a {

    /* compiled from: UIntArray.kt */
    /* loaded from: classes3.dex */
    private static final class a implements Iterator<n>, kotlin.jvm.internal.z.a {
        private final int[] a;
        private int b;

        public a(int[] array) {
            kotlin.jvm.internal.s.h(array, "array");
            this.a = array;
        }

        public int a() {
            int i2 = this.b;
            int[] iArr = this.a;
            if (i2 < iArr.length) {
                this.b = i2 + 1;
                int i3 = iArr[i2];
                n.b(i3);
                return i3;
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ n next() {
            return n.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static Iterator<n> a(int[] iArr) {
        return new a(iArr);
    }
}
