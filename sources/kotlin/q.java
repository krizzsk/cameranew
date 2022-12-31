package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: ULongArray.kt */
/* loaded from: classes3.dex */
public final class q implements Collection<p>, kotlin.jvm.internal.z.a {

    /* compiled from: ULongArray.kt */
    /* loaded from: classes3.dex */
    private static final class a implements Iterator<p>, kotlin.jvm.internal.z.a {
        private final long[] a;
        private int b;

        public a(long[] array) {
            kotlin.jvm.internal.s.h(array, "array");
            this.a = array;
        }

        public long a() {
            int i2 = this.b;
            long[] jArr = this.a;
            if (i2 < jArr.length) {
                this.b = i2 + 1;
                long j2 = jArr[i2];
                p.b(j2);
                return j2;
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ p next() {
            return p.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static Iterator<p> a(long[] jArr) {
        return new a(jArr);
    }
}
