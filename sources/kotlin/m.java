package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: UByteArray.kt */
/* loaded from: classes3.dex */
public final class m implements Collection<l>, kotlin.jvm.internal.z.a {

    /* compiled from: UByteArray.kt */
    /* loaded from: classes3.dex */
    private static final class a implements Iterator<l>, kotlin.jvm.internal.z.a {
        private final byte[] a;
        private int b;

        public a(byte[] array) {
            kotlin.jvm.internal.s.h(array, "array");
            this.a = array;
        }

        public byte a() {
            int i2 = this.b;
            byte[] bArr = this.a;
            if (i2 < bArr.length) {
                this.b = i2 + 1;
                byte b = bArr[i2];
                l.b(b);
                return b;
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ l next() {
            return l.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static Iterator<l> a(byte[] bArr) {
        return new a(bArr);
    }
}
